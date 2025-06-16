package delicious.food.map.service;

import delicious.food.map.entity.SysUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import delicious.food.map.model.UserLoginModel;
import delicious.food.map.model.UserRegisterModel;
import delicious.food.map.model.UserResultModel;

/**
 * 系统用户 服务类
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 通过ID 查找用户
     * @return SysEntity
     */
    SysUserEntity getUserById(String userId);

    /**
     * 注册用户
     *
     * @param user 用户信息
     * @return 注册结果
     */
    boolean register(UserRegisterModel user);

    /**
     * 登录
     *
     * @param user 用户信息
     * @return 登录结果
     */
    UserResultModel login(UserLoginModel user);

    /**
     * 登出
     *
     * @param userId 用户id
     * @return 登出结果
     */
    boolean logout(String userId);
}
