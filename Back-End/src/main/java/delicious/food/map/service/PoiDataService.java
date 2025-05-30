package delicious.food.map.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import delicious.food.map.entity.PoiDataEntity;
import delicious.food.map.model.PaginationModel;
import delicious.food.map.model.PoiDataResultModel;
import delicious.food.map.model.PoiDataSearchModel;

import java.util.List;

/**
 * 美食地点数据 服务类
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
public interface PoiDataService extends IService<PoiDataEntity> {

    /**
     * 分页获取所有 Poi 数据
     */
    List<PoiDataEntity> getAll(PaginationModel page);

    /**
     * 条件搜索所有美食数据
     */
    IPage<PoiDataResultModel> search(PoiDataSearchModel searchModel);

}
