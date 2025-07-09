package delicious.food.map.model;

import delicious.food.map.common.validator.group.SearchPoiData;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 美食数据搜索条件Model
 *
 * @author dhbxs
 * @since 2025/05/30 13:36
 */
@Data
public class PoiDataSearchModel extends PaginationModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 美食数据ID
     */
    @Size(min = 19, max = 19, message = "美食数据ID必须为19位", groups = {SearchPoiData.class})
    private String id;

    /**
     * 检索关键词
     */
    @Size(min = 0, max = 100, message = "检索关键词最多不超过100个字符", groups = {SearchPoiData.class})
    private String keywords;

    /**
     * 美食分类ID
     */
    @Size(min = 19, message = "美食分类ID必须为19位", groups = {SearchPoiData.class})
    private String categoryId;
}
