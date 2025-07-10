package delicious.food.map.service;

/**
 * 验证码 校验服务
 *
 * @author dhbxs
 * @since 2025/06/16
 */
public interface CaptchaService {

    /**
     * 校验验证码
     *
     * @param captchaId 验证码ID
     * @param code    用户输入的验证码值
     * @return 校验结果
     */
    boolean checkCaptchaCode(String captchaId, String code);
}
