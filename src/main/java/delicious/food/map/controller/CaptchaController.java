package delicious.food.map.controller;


import delicious.food.map.common.Constant;
import delicious.food.map.common.JsonResult;
import delicious.food.map.common.StatusCode;
import delicious.food.map.config.aop.RateLimit;
import delicious.food.map.exception.BusinessException;
import delicious.food.map.model.CaptchaResultModel;
import delicious.food.map.service.CaptchaService;
import delicious.food.map.utils.CaptchaUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 图形验证码 接口
 *
 * @author dhbxs
 * @since 2025/06/16
 */
@RestController
@RequestMapping("/captcha")
@Slf4j
public class CaptchaController {

    @Resource
    private CaptchaService captchaService;

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 生成验证码接口
     *
     * @return CaptchaResultModel 验证码以及验证码所对应的id
     */
    @PostMapping("/getCaptcha")
    @RateLimit(key = "publicInterface", permitsPerSecond = 100, timeout = 500)
    public JsonResult<CaptchaResultModel> getCaptcha() {

        String uuid = UUID.randomUUID().toString().toUpperCase();
        String redisKey = Constant.REDIS_CAPTCHA_ID_PREFIX.getText() + uuid;
        try {
            String[] captchaObj = CaptchaUtil.newBuilder().build().createImage();

            redisTemplate.opsForValue().set(redisKey, captchaObj[0],300, TimeUnit.SECONDS);

            String captchaImgBase64 = captchaObj[1];

            return JsonResult.success(new CaptchaResultModel(uuid, captchaImgBase64));
        } catch (Exception e) {
            log.error("验证码生成失败", e);
            throw new BusinessException(StatusCode.SYSTEM_ERROR, "验证码生成失败");
        }
    }
}
