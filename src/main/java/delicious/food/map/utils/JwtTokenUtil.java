package delicious.food.map.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * JwtToken工具类
 *
 * @author dhbxs
 * @since 2024/3/19 9:21
 */
@Component
@Slf4j
public class JwtTokenUtil {

    private JwtTokenUtil() {
    }

    /**
     * 生成Token字符串工具
     *
     * @param userId   用户id 作为JWT载荷
     * @param userName 用户名userName 作为JWT载荷
     * @param roleId   用户角色id 作为JWT载荷
     * @return 返回生成的Token字符串
     */
    public static Map<String, String> genJwtToken(String userId, String userName, String roleId) {
        Map<String, String> result = new HashMap<>();

        // 用随机UUID做为JWT Token签名的密钥
        String sign = UUID.randomUUID().toString().toUpperCase();
        String token = JWT.create().withAudience(userId, userName, roleId) // 将userid保存到token里面，作为载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1 * 60 * 60 * 1000)) // 1小时后token过期
                .sign(Algorithm.HMAC256(sign));

        result.put("jwtToken", token);
        result.put("sign", sign);

        return result;
    }
}
