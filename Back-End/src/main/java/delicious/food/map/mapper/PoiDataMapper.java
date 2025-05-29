package delicious.food.map.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import delicious.food.map.entity.PoiDataEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import delicious.food.map.model.PaginationModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 美食地点数据 Mapper 接口
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
@Mapper
public interface PoiDataMapper extends BaseMapper<PoiDataEntity> {

}
