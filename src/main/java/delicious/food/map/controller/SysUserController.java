package delicious.food.map.controller;


import delicious.food.map.common.JsonResult;
import delicious.food.map.common.StatusCode;
import delicious.food.map.config.aop.RateLimit;
import delicious.food.map.exception.BusinessException;
import delicious.food.map.model.UserLoginModel;
import delicious.food.map.model.UserRegisterModel;
import delicious.food.map.model.UserResultModel;
import delicious.food.map.service.CaptchaService;
import delicious.food.map.service.SysUserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户表 前端控制器
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Resource
    private SysUserService userService;

    @Resource
    private CaptchaService captchaService;

    /**
     * 用户登录接口
     *
     * @param user 用户
     * @return 登录结果
     */
    @PostMapping("/login")
    @RateLimit(key = "sysInterface", permitsPerSecond = 50, timeout = 500)
    public JsonResult<UserResultModel> login(HttpServletRequest request, @RequestBody UserLoginModel user) {

        boolean checked = captchaService.checkCaptchaCode(request, user.getVerifyCode());

        if (!checked) {
            throw new BusinessException(StatusCode.CAPTCHA_ERROR);
        }

        UserResultModel result = userService.login(user);
        return JsonResult.success(result);
    }

    /**
     * 用户注册接口
     *
     * @param user 用户信息
     * @return 注册结果
     */
    @PostMapping("/register")
    @RateLimit(key = "registerInterface", permitsPerSecond = 5, timeout = 500)
    public JsonResult<Boolean> register(HttpServletRequest request, @RequestBody UserRegisterModel user) {
        boolean checked = captchaService.checkCaptchaCode(request, user.getVerifyCode());

        if (!checked) {
            throw new BusinessException(StatusCode.CAPTCHA_ERROR);
        }

        boolean result = userService.register(user);
        return JsonResult.success(result);
    }

}
