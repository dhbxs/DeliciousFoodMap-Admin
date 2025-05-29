package delicious.food.map.service;

import delicious.food.map.entity.SysUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
