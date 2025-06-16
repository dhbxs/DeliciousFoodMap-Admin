package delicious.food.map.service.impl;

import delicious.food.map.service.CaptchaService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 校验验证码
 *
 * @author dhbxs
 * @since 2025/06/16
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

    /**
     * 校验验证码
     *
     * @param request 请求
     * @param code    验证码
     * @return 校验结果
     */
    @Override
    public boolean checkCaptchaCode(HttpServletRequest request, String code) {
        final long CAPTCHA_EXPIRE_MS = 5 * 60 * 1000; // 验证码有效期5分钟，单位毫秒，可自行修改，建议不超过10分钟，超过10分钟请自行处理

        String sessionCaptchaCode = (String) request.getSession().getAttribute("Captcha_Code");
        Long captchaTime = (Long) request.getSession().getAttribute("Captcha_Time");

        long currentTime = System.currentTimeMillis();

        if ((captchaTime != null)
                && (currentTime - captchaTime < CAPTCHA_EXPIRE_MS)
                && (StringUtils.equalsIgnoreCase(code, sessionCaptchaCode))
        ) {
                request.getSession().removeAttribute("Captcha_Code");
                return true;
        }

        request.getSession().removeAttribute("Captcha_Code");
        request.getSession().removeAttribute("Captcha_Time");
        return false;
    }
}
