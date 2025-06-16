package delicious.food.map.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 用户登录Model
 *
 * @author dhbxs
 * @since 2025/6/14
 */
@Data
public class UserLoginModel {

    /**
     * 用户邮箱
     */
    @Email(message = "邮箱地址错误")
    private String email;

    /**
     * 用户密码
     */
    @NotBlank
    @Size(min = 8, max = 40, message = "密码长度必须在 8 ~ 40 位之间")
    private String password;

    /**
     * 验证码
     */
    @NotBlank
    @Size(min = 6, max = 6, message = "验证码长度必须为 4 位")
    private String verifyCode;

}
