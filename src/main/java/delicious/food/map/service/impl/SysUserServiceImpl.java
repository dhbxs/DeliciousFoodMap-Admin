package delicious.food.map.service.impl;

import delicious.food.map.entity.SysUserEntity;
import delicious.food.map.mapper.SysUserMapper;
import delicious.food.map.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 系统用户 服务实现类
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    /**
     * 通过ID 查找用户
     *
     * @param userId 用户ID
     * @return SysEntity
     */
    @Override
    public SysUserEntity getUserById(String userId) {
        return sysUserMapper.selectById(userId);
    }
}
