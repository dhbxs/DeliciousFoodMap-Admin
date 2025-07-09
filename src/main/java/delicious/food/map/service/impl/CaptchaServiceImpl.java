package delicious.food.map.service.impl;

import delicious.food.map.common.Constant;
import delicious.food.map.service.CaptchaService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 校验验证码
 *
 * @author dhbxs
 * @since 2025/06/16
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 校验验证码
     *
     * @param captchaId 验证码ID
     * @param code    用户输入的验证码值
     * @return 校验结果
     */
    @Override
    public boolean checkCaptchaCode(String captchaId, String code) {

        String captchaCode = redisTemplate.opsForValue().get(Constant.REDIS_CAPTCHA_ID_PREFIX.getText() + captchaId);

        if (StringUtils.isNotBlank(captchaCode) && StringUtils.equals(captchaCode, code)) {
            redisTemplate.delete(Constant.REDIS_CAPTCHA_ID_PREFIX.getText() + captchaId);
            return true;
        }
        return false;
    }
}
