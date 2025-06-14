package delicious.food.map.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应状态信息枚举定义
 *
 * @author dhbxs
 * @since 2024-03-11
 */
@Getter
@AllArgsConstructor
public enum StatusCode {
    SUCCESS("200", "OK", ""),
    PARAMS_ERROR("4000", "请求参数错误", ""),
    NOT_LOGIN("5000", "未登录", ""),
    USERNAME_EMAIL_REPEAT("5001", "邮箱或用户名重复", ""),
    USER_NOT_EXIST_OR_PASSWORD_ERROR("5002", "用户不存在或密码错误", ""),
    SYSTEM_ERROR("6000", "系统内部错误", "");

    /**
     * 状态码
     */
    private final String code;

    /**
     * 错误信息
     */
    private final String message;

    /**
     * 详细错误描述
     */
    private final String description;

}
