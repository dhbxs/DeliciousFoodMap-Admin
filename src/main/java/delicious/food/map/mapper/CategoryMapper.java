package delicious.food.map.mapper;

import delicious.food.map.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import delicious.food.map.model.CategoryResultModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 分类 Mapper 接口
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryEntity> {

    /**
     * 获取分类数据 - 包含该分类下的美食数据量
     *
     * @return 分类数据
     */
    List<CategoryResultModel> getAllCategoryData();

}
