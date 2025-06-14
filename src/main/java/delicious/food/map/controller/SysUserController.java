package delicious.food.map.controller;


import delicious.food.map.common.JsonResult;
import delicious.food.map.model.UserLoginModel;
import delicious.food.map.model.UserRegisterModel;
import delicious.food.map.model.UserResultModel;
import delicious.food.map.service.SysUserService;
import jakarta.annotation.Resource;
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

    /**
     * 用户登录接口
     *
     * @param user 用户
     * @return 登录结果
     */
    @PostMapping("/login")
    public JsonResult<UserResultModel> login(@RequestBody UserLoginModel user) {
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
    public JsonResult<Boolean> register(@RequestBody UserRegisterModel user) {
        boolean result = userService.register(user);
        return JsonResult.success(result);
    }

}
