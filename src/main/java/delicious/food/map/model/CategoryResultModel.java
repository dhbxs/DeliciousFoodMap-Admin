package delicious.food.map.model;


import lombok.Data;

/**
 * 分类数据查询结果
 *
 * @author dhbxs
 * @since 2025-06-13
 */
@Data
public class CategoryResultModel {

    /**
     * id
     */
    private String id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 显示名称
     */
    private String displayName;

    /**
     * 分类颜色色号 Hex
     */
    private String color;

    /**
     * 分类图标类名
     */
    private String icon;

    /**
     * 是否删除
     * Y - 已删除
     * N - 未删除
     */
    private String isDelete;

    /**
     * 该分类下的美食店铺数量
     */
    private String num;
}
