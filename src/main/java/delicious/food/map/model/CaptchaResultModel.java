package delicious.food.map.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author dhbxs
 * @since 2025/07/09 15:27
 */
@Data
@AllArgsConstructor
public class CaptchaResultModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 验证码ID
     */
    private String captchaId;

    /**
     * 验证码图片 Base64
     */
    private String captchaImageBase64;
}
