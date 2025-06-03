package delicious.food.map.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统全局常量枚举
 */
@Getter
@AllArgsConstructor
public enum Constant {
    ERROR("出错了");

    private final String text;
}
