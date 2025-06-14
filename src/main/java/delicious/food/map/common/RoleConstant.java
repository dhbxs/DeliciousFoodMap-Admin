package delicious.food.map.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统角色枚举
 *
 * @author dhbxs
 * @since 2025/6/14
 */
@Getter
@AllArgsConstructor
public enum RoleConstant {

    ADMIN(1L, "管理员"),
    USER(2L, "普通用户");

    /**
     * 角色id
     */
    private final Long id;

    /**
     * 角色名称
     */
    private final String name;
}
