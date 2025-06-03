package delicious.food.map.utils;

import org.springframework.util.DigestUtils;

/**
 * 加密密码的工具类
 *
 * @author dhbxs
 * @since 2024/12/11 18:17
 */
public class CryptPasswordUtil {

    /**
     * MD5给密码加密
     *
     * @param password 明文密码
     * @param salt     随机盐值
     * @return 加密后的密码（密文）
     */
    public static String getMD5Password(String password, String salt) {
        // 循环3次，即加密算法加密三次
        for (int i = 0; i < 3; i++) {
            // MD5加密算法调用 盐值 + 密码 + 盐值 组合
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        // 返回加密之后的密码
        return password;
    }
}
