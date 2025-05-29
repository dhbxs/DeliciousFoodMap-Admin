package delicious.food.map.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 手机号格式验证
 *
 * @author dhbxs
 * @since 2025/1/15 9:31
 */
public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    private static final String PHONE_REGEX = "^1[3-9]\\d{9}$";

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
    
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches(PHONE_REGEX);
    }
}
