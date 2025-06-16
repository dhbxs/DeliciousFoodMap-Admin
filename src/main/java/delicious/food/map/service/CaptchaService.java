package delicious.food.map.service;

import jakarta.servlet.http.HttpServletRequest;

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
     * @param request 请求
     * @param code    验证码
     * @return 校验结果
     */
    boolean checkCaptchaCode(HttpServletRequest request, String code);
}
