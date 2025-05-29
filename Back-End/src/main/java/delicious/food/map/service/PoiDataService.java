package delicious.food.map.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import delicious.food.map.entity.PoiDataEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import delicious.food.map.model.PaginationModel;

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

}
