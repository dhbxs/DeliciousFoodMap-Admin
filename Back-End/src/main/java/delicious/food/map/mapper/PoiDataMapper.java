package delicious.food.map.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import delicious.food.map.entity.PoiDataEntity;
import delicious.food.map.model.PoiDataResultModel;
import delicious.food.map.model.PoiDataSearchModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 美食地点数据 Mapper 接口
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
@Mapper
public interface PoiDataMapper extends BaseMapper<PoiDataEntity> {

    /**
     * 搜索美食地点数据
     *
     * @param searchModel 搜索参数
     * @return 搜索结果
     */
    IPage<PoiDataResultModel> search(IPage<?> page, @Param("searchModel") PoiDataSearchModel searchModel);

}
