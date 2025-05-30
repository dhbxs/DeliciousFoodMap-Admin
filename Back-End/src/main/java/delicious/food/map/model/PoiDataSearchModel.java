package delicious.food.map.model;

import lombok.Data;

/**
 * 美食数据搜索条件Model
 *
 * @author dhbxs
 * @since 2025/05/30 13:36
 */
@Data
public class PoiDataSearchModel extends PaginationModel{

    /**
     * 检索关键词
     */
    private String keywords;

    /**
     * 美食分类ID
     */
    private String categoryId;
}
