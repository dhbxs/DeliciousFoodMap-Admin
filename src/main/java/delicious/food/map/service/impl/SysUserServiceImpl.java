package delicious.food.map.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import delicious.food.map.common.RoleConstant;
import delicious.food.map.common.StatusCode;
import delicious.food.map.entity.SysUserEntity;
import delicious.food.map.exception.BusinessException;
import delicious.food.map.mapper.SysUserMapper;
import delicious.food.map.model.UserLoginModel;
import delicious.food.map.model.UserRegisterModel;
import delicious.food.map.model.UserResultModel;
import delicious.food.map.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import delicious.food.map.utils.CryptPasswordUtil;
import delicious.food.map.utils.JwtTokenUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * 系统用户 服务实现类
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

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

    /**
     * 注册用户
     *
     * @param user 用户信息
     * @return 注册结果
     */
    @Override
    public boolean register(UserRegisterModel user) {

        LambdaQueryWrapper<SysUserEntity> wrapper = new LambdaQueryWrapper<SysUserEntity>()
                .select(SysUserEntity::getId)
                .eq(SysUserEntity::getEmail, user.getEmail())
                .or()
                .eq(SysUserEntity::getNickName, user.getNickName());

        if (sysUserMapper.selectOne(wrapper) != null) {
            throw new BusinessException(StatusCode.USERNAME_EMAIL_REPEAT);
        }

        Date now = new Date();
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setNickName(user.getNickName());
        sysUserEntity.setEmail(user.getEmail());

        // 注册用户只能是普通用户 角色id为2
        sysUserEntity.setRoleId(RoleConstant.USER.getId());

        String salt = CryptPasswordUtil.getSecureRandomString();
        String md5Password = CryptPasswordUtil.getMD5Password(user.getPassword(), salt);

        sysUserEntity.setSalt(salt);
        sysUserEntity.setPassword(md5Password);
        sysUserEntity.setCreatedTime(now);
        sysUserEntity.setModifiedTime(now);
        int insert = sysUserMapper.insert(sysUserEntity);

        return insert > 0;
    }

    /**
     * 登录
     *
     * @param user 用户信息
     * @return 登录结果
     */
    @Override
    public UserResultModel login(UserLoginModel user) {
        LambdaQueryWrapper<SysUserEntity> wrapper = new LambdaQueryWrapper<SysUserEntity>().eq(SysUserEntity::getEmail, user.getEmail());
        SysUserEntity sysUserEntity = sysUserMapper.selectOne(wrapper);

        if (sysUserEntity == null) {
            throw new BusinessException(StatusCode.USER_NOT_EXIST_OR_PASSWORD_ERROR);
        }

        if (!CryptPasswordUtil.verifyPassword(user.getPassword(), sysUserEntity.getSalt(), sysUserEntity.getPassword())) {
            throw new BusinessException(StatusCode.USER_NOT_EXIST_OR_PASSWORD_ERROR);
        }

        UserResultModel userResultModel = new UserResultModel();
        userResultModel.setId(sysUserEntity.getId());
        userResultModel.setNickName(sysUserEntity.getNickName());
        userResultModel.setEmail(sysUserEntity.getEmail());
        userResultModel.setRoleId(sysUserEntity.getRoleId());

        Map<String, String> jwtTokenMap = JwtTokenUtil.genJwtToken(sysUserEntity.getId(), sysUserEntity.getNickName(), sysUserEntity.getRoleId().toString());
        String jwtToken = jwtTokenMap.get("jwtToken");
        String sign = jwtTokenMap.get("sign");
        userResultModel.setJwtToken(jwtToken);

        sysUserEntity.setSign(sign);
        sysUserMapper.updateById(sysUserEntity);

        return userResultModel;
    }


}
