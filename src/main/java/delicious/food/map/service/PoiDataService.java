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
     */
    IPage<PoiDataResultModel> search(PoiDataSearchModel searchModel);

}
