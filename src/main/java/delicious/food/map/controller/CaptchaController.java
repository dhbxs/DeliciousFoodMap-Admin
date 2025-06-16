package delicious.food.map.controller;


import delicious.food.map.common.StatusCode;
import delicious.food.map.config.aop.RateLimit;
import delicious.food.map.exception.BusinessException;
import delicious.food.map.service.CaptchaService;
import delicious.food.map.utils.CaptchaUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

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

    /**
     * 生成验证码接口
     *
     * @param request  请求对象
     * @param response 响应对象
     */
    @GetMapping("/getCaptcha.png")
    @RateLimit(key = "publicInterface", permitsPerSecond = 100, timeout = 500)
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        try {
            Object[] captchaObj = CaptchaUtil.newBuilder().build().createImage();
            session.setAttribute("Captcha_Code", captchaObj[0]);
            session.setAttribute("Captcha_Time", System.currentTimeMillis());

            BufferedImage captchaImg = (BufferedImage) captchaObj[1];

            response.setContentType(MediaType.IMAGE_PNG_VALUE);
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(captchaImg, "png", outputStream);
        } catch (Exception e) {
            log.error("验证码生成失败 SESSION_ID {}", sessionId);
            throw new BusinessException(StatusCode.SYSTEM_ERROR);
        }
    }
}
