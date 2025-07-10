package delicious.food.map.exception;

import delicious.food.map.common.JsonResult;
import delicious.food.map.common.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 *
 * @author dhbxs
 * @since 2024/3/19 15:27
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public <T> JsonResult<T> businessExceptionHandler(BusinessException e) {
        log.error("BusinessException: {} {}", e.getMessage(), e.getDescription(), e);
        return JsonResult.error(e.getCode(), e.getMessage(), e.getDescription());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResult<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException: {}", e.getMessage(), e);
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );

        String errorMessage = String.join("，", errors.values());

        return JsonResult.error(StatusCode.PARAMS_ERROR, errorMessage, errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public <T> JsonResult<T> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        log.error("HttpMessageNotReadableException: {}", e.getMessage(), e);
        return JsonResult.error(StatusCode.PARAMS_ERROR, "请求参数错误");
    }

    @ExceptionHandler(RuntimeException.class)
    public <T> JsonResult<T> runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException: {}", e.getMessage(), e);
        return JsonResult.error(StatusCode.SYSTEM_ERROR, "系统内部出错了，请联系系统管理员");
    }
}
