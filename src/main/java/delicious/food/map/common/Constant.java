package delicious.food.map.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统全局常量枚举
 */
@Getter
@AllArgsConstructor
public enum Constant {
    REDIS_CAPTCHA_ID_PREFIX("Captcha_"),
    ;

    private final String text;
}
