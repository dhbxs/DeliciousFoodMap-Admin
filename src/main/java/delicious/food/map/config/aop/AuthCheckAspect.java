package delicious.food.map.config.aop;

import com.auth0.jwt.JWT;
import delicious.food.map.common.StatusCode;
import delicious.food.map.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.List;

/**
 * 权限校验切面
 *
 * @author dhbxs
 * @since 2025/06/23 9:44
 */
@Aspect
@Component
public class AuthCheckAspect {

    @Order(2)
    @Around("@annotation(authCheck)")
    public Object authCheck(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        String token = request.getHeader("Authorization").substring(7);

        if (StringUtils.isBlank(token)) {
            throw new BusinessException(StatusCode.NOT_LOGIN);
        }
        // 用户当前角色
        String userRoleId = JWT.decode(token).getAudience().get(2);

        // 接口允许的角色列表
        List<String> permittedRoleList = Arrays.stream(authCheck.role()).map(id -> id.getId().toString()).toList();

        boolean hasPermission = permittedRoleList.contains(userRoleId);

        if (!hasPermission) {
            throw new BusinessException(StatusCode.NOT_AUTH);
        }

        // 通过权限校验，放行
        return joinPoint.proceed();
    }
}
