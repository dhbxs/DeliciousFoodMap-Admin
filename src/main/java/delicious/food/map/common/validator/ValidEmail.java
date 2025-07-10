package delicious.food.map.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  自定义邮箱格式验证注解
 *  @author ：aim467
 *  @since 2025/6/27 下午 15:45
 */
@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {
    String message() default "邮箱格式不正确或后缀不被支持";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
