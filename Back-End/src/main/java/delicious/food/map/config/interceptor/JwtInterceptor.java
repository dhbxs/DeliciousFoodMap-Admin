package delicious.food.map.config.interceptor;

import delicious.food.map.common.JsonResult;
import delicious.food.map.common.StatusCode;
import com.alibaba.fastjson2.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import delicious.food.map.entity.SysUserEntity;
import delicious.food.map.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

/**
 * JwtToken 校验拦截器
 *
 * @author dhbxs
 * @since 2024-03-19 10:16:00
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    protected SysUserService sysUserService;

    private static JwtInterceptor jwtInterceptor;

    @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
    public void init() {
        jwtInterceptor = this;
        jwtInterceptor.sysUserService = this.sysUserService;
        // 初使化时将已静态化的testService实例化
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // 执行认证
        if (StringUtils.isBlank(token)) {
            setErrorResponse(response, "当前未登录，请访问首页重新登录");
            return false;
        } else {
            // 将Authorization字段值去掉前面的Bearea
            token = token.substring(7);
        }
        // 获取token中的user id
        String userId;
        String userName;
        try {
            userId = JWT.decode(token).getAudience().get(0);
            userName = JWT.decode(token).getAudience().get(1);
        } catch (JWTDecodeException j) {
            setErrorResponse(response, "用户信息不完整，请重新登录");
            return false;
        }

        SysUserEntity user = jwtInterceptor.sysUserService.getUserById(userId);
        if (Objects.isNull(user)) {
            setErrorResponse(response, "用户不存在，请重新登录");
            return false;
        } else if (StringUtils.isBlank(user.getSign())) {
            setErrorResponse(response, "未登录或登录失效，请重新登录");
            return false;
        }

        // 验证token 用户密码加签名验证token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getSign())).build();
        try {
            jwtVerifier.verify(token); // 验证token
        } catch (JWTVerificationException e) {
            setErrorResponse(response, "登录失效，请重新登录");
            return false;
        }
        return true;
    }

    private static void setErrorResponse(HttpServletResponse response, String description) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(JsonResult.error(StatusCode.NOT_LOGIN, description)));
    }
}
