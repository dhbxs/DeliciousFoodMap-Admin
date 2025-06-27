package delicious.food.map.common.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

/**
 * 邮箱格式验证
 * @author aim4679
 * @since 2025/6/27 下午 15:45
 */
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    // 支持的邮箱后缀
    private static final List<String> SUPPORTED_DOMAINS = Arrays.asList(
            "@qq.com",
            "@163.com",
            "@gmail.com",
            "@outlook.com",
            "@126.com",
            "@sina.com",
            "@hotmail.com",
            "@yahoo.com"
    );

    // 最大邮箱长度限制
    private static final int MAX_EMAIL_LENGTH = 64;

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null) {
            return false; // 非空检查
        }

        if (email.length() > MAX_EMAIL_LENGTH) {
            return false; // 邮箱长度检查
        }

        // 第一步：检查邮箱是否符合基本格式
        if (!email.matches(EMAIL_REGEX)) {
            return false;
        }

        // 第二步：检查邮箱后缀是否在允许范围内
        return SUPPORTED_DOMAINS.stream().anyMatch(email::endsWith);
    }
}

