package delicious.food.map.common;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应结果Json封装
 *
 * @author dhbxs
 * @since 2024-03-08
 */
@Data
@NoArgsConstructor
public class JsonResult<T> {

    /**
     * 状态码
     */
    private String code;

    /**
     * 状态信息
     */
    private String message;

    /**
     * 状态描述详情
     */
    private String description;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 自定义 状态码 响应
     *
     * @param code 状态码
     */
    public JsonResult(String code) {
        this(code, "", "", null);
    }

    /**
     * 自定义 状态码 + 数据 响应
     *
     * @param code 状态码
     */
    public JsonResult(String code, T data) {
        this(code, "", "", data);
    }

    /**
     * 自定义 状态码 + 信息 + 数据 响应
     *
     * @param code    状态码
     * @param message 状态信息
     * @param data    响应数据
     */
    public JsonResult(String code, String message, T data) {
        this(code, message, "", data);
    }

    /**
     * 自定义 状态码 + 信息 + 描述 + 数据 响应
     *
     * @param code    状态码
     * @param message 状态信息
     * @param data    响应数据
     */
    public JsonResult(String code, String message, String description, T data) {
        this.code = code;
        this.message = message;
        this.description = description;
        this.data = data;
    }

    /**
     * 自定义 状态码 + 信息 + 描述 响应
     *
     * @param code    状态码
     * @param message 状态信息
     */
    public JsonResult(String code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    /**
     * 指定 状态码响应
     *
     * @param statusCode 响应状态信息枚举值
     */
    public JsonResult(StatusCode statusCode) {
        this(statusCode.getCode(), statusCode.getMessage(), statusCode.getDescription(), null);
    }

    /**
     * 指定 状态码 + 数据 响应
     *
     * @param statusCode 响应状态信息枚举值
     * @param data       响应数据
     */
    public JsonResult(StatusCode statusCode, T data) {
        this(statusCode.getCode(), statusCode.getMessage(), statusCode.getDescription(), data);
    }

    /**
     * 指定 状态码 + 自定义描述 响应
     *
     * @param statusCode 响应状态信息枚举值
     */
    public JsonResult(StatusCode statusCode, String description) {
        this(statusCode.getCode(), statusCode.getMessage(), description);
    }

    /**
     * 响应 成功
     *
     * @param <T> 泛型方法
     * @return 响应结果
     */
    public static <T> JsonResult<T> success() {
        return new JsonResult<>(StatusCode.SUCCESS);
    }

    /**
     * 响应 成功 + 数据
     *
     * @param data 响应数据
     * @param <T>  泛型方法
     * @return 响应结果
     */
    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<>(StatusCode.SUCCESS, data);
    }

    /**
     * 响应 错误
     *
     * @param <T> 泛型方法
     * @return 响应结果
     */
    public static <T> JsonResult<T> error(StatusCode statusCode) {
        return new JsonResult<>(statusCode);
    }

    /**
     * 响应 错误 + 数据
     *
     * @param <T> 泛型方法
     * @return 响应结果
     */
    public static <T> JsonResult<T> error(StatusCode statusCode, T data) {
        return new JsonResult<>(statusCode, data);
    }


    /**
     * 响应 错误 + 自定义描述
     *
     * @param <T> 泛型方法
     * @return 响应结果
     */
    public static <T> JsonResult<T> error(StatusCode statusCode, String description) {
        return new JsonResult<>(statusCode, description);
    }

    /**
     * 自定义响应 错误 + 错误信息 + 错误描述
     *
     * @param <T> 泛型方法
     * @return 响应结果
     */
    public static <T> JsonResult<T> error(String code, String message, String description) {
        return new JsonResult<>(code, message, description);
    }
}