package delicious.food.map.model;

import lombok.Data;

/**
 * 用户 Model
 * 登录后返回必要用户数据
 *
 * @author dhbxs
 * @since 2025/6/14
 */
@Data
public class UserResultModel {

    /**
     * 用户id
     */
    private String id;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户角色id
     */
    private Long roleId;

    /**
     * JWT token
     */
    private String jwtToken;
}
