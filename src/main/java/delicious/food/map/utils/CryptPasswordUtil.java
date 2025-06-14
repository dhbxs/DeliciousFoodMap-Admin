package delicious.food.map.utils;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.security.SecureRandom;

/**
 * 加密密码的工具类
 *
 * @author dhbxs
 * @since 2024/12/11 18:17
 */
@Data
public class CryptPasswordUtil {

    /**
     * 生成32位安全的随机字母数字字符串
     *
     * @return 安全随机字符串
     */
    public static String getSecureRandomString() {
        // 使用安全随机源替代默认的Random
        SecureRandom random = new SecureRandom();

        // 生成包含字母和数字的字符串

        return RandomStringUtils.random(
                32,
                0,
                0,
                true,
                true,
                null,
                random
        );
    }

    /**
     * 密码加密保存
     *
     * @param password 密码
     */
    public static String getMD5Password(String password, String salt) {

        // 循环3次，即加密算法加密三次
        for (int i = 0; i < 3; i++) {
            // MD5加密算法调用 盐值 + 密码 + 盐值 组合
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }

        return password;
    }

    /**
     * 验证密码
     *
     * @param password       用户输入的密码
     * @param salt           数据库中的盐值
     * @param md5Password    数据库中的MD5密码
     * @return 是否匹配
     */
    public static boolean  verifyPassword(String password, String salt, String md5Password) {
        return StringUtils.equals(md5Password, getMD5Password(password, salt));
    }
}
