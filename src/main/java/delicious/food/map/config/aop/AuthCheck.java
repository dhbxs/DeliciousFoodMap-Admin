package delicious.food.map.config.aop;

import delicious.food.map.common.RoleConstant;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 权限校验注解
 * @author dhbxs
 * @since 2025/06/23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface AuthCheck {

    /**
     * 角色权限
     * 默认为普通用户权限
     */
    RoleConstant[] role() default {RoleConstant.USER};
}
