package delicious.food.map.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 分类 Entity
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
@Data
@TableName("category")
public class CategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 分类名称
     */
    @TableField("name")
    private String name;

    /**
     * 显示名称
     */
    @TableField("display_name")
    private String displayName;

    /**
     * 分类颜色色号 Hex
     */
    @TableField("color")
    private String color;

    /**
     * 分类图标类名
     */
    @TableField("icon")
    private String icon;


}
