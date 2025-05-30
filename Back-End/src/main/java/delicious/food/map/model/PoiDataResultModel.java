package delicious.food.map.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 美食数据检索结果响应Model
 *
 * @author dhbxs
 * @since 2025/05/30 14:17
 */
@Data
public class PoiDataResultModel {

    /**
     * 店铺ID
     */
    private String id;

    /**
     * 店名
     */
    private String name;

    /**
     * 地址
     */
    private String address;

    /**
     * 描述
     */
    private String description;

    /**
     * 分类 ID
     */
    private String categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类显示名称
     */
    private String categoryDisplayName;

    /**
     * 分类颜色色号 Hex
     */
    private String categoryColor;

    /**
     * 分类图标类名
     */
    private String categoryIcon;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifiedTime;

    /**
     * 店铺相片
     */
    private String photo;

}
