package delicious.food.map.model;

import delicious.food.map.common.validator.ValidEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户注册Model
 *
 * @author dhbxs
 * @since 2025/6/14
 */
@Data
public class UserRegisterModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 验证码ID
     */
    @Size(min = 19, max = 19, message = "验证码ID必须为19位")
    private String captchaId;

    /**
     * 用户昵称
     */
    @NotBlank
    @Size(min = 2, max = 10, message = "用户昵称长度必须在 2 ~ 10 位之间")
    private String nickName;

    /**
     * 密码
     */
    @NotBlank
    @Size(min = 8, max = 40, message = "密码长度必须在 8 ~ 40 位之间")
    private String password;

    /**
     * 邮箱
     */
    @NotBlank
    @ValidEmail(message = "邮箱格式错误")
    private String email;

    /**
     * 验证码
     */
    @NotBlank
    @Size(min = 6, max = 6, message = "验证码长度必须为 4 位")
    private String verifyCode;
}
