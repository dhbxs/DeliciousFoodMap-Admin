package delicious.food.map.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import delicious.food.map.entity.PoiDataEntity;
import delicious.food.map.model.PoiDataResultModel;
import delicious.food.map.model.PoiDataSearchModel;

/**
 * 美食地点数据 服务类
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
public interface PoiDataService extends IService<PoiDataEntity> {

    /**
     * 条件搜索所有美食数据
     *
     * @param searchModel 搜索条件
     * @return 搜索结果
     */
    IPage<PoiDataResultModel> search(PoiDataSearchModel searchModel);

    /**
     * 美食数据 增删改业
     * 有ID则更新 无则ID或ID不存在则新增
     * isDelete 值为Y则删除 值为空或值为N则不删除
     *
     * @param userId        当前操作用户的 ID
     * @param poiDataEntity 美食数据
     * @return 执行结果i
     */
    boolean insertOrUpdateOrDeletePoiData(String userId, PoiDataEntity poiDataEntity);
}
