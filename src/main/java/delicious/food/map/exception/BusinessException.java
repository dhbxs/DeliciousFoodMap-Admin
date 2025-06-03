package delicious.food.map.exception;

import delicious.food.map.common.StatusCode;
import lombok.Getter;

/**
 * 业务异常类
 *
 * @author dhbxs
 * @since 2024/3/19 17:07
 */
@Getter
public class BusinessException extends RuntimeException {

    /**
     * 异常码
     */
    private final String code;

    /**
     * 描述
     */
    private final String description;

    public BusinessException(String code, String message, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BusinessException(StatusCode statusCode) {
        super(statusCode.getMessage());
        this.code = statusCode.getCode();
        this.description = statusCode.getDescription();
    }

    public BusinessException(StatusCode statusCode, String description) {
        super(statusCode.getMessage());
        this.code = statusCode.getCode();
        this.description = description;
    }
}
