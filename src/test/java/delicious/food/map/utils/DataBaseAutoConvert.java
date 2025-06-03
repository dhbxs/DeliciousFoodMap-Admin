package delicious.food.map.utils;


import delicious.food.map.entity.CategoryEntity;
import delicious.food.map.entity.PoiDataEntity;
import delicious.food.map.mapper.CategoryMapper;
import delicious.food.map.mapper.PoiDataMapper;
import jakarta.annotation.Resource;
import org.apache.ibatis.executor.BatchResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 数据库数据迁移导入整理
 *
 * @author dhbxs
 * @since  2023/09/05
 */
@SpringBootTest
class DataBaseAutoConvert {

    @Resource
    private PoiDataMapper poiDataMapper;

    @Resource
    private CategoryMapper categoryMapper;

    @Test
    void main() {

        List<PoiDataEntity> poiDataEntityList = poiDataMapper.selectList(null);

        poiDataMapper.deleteByIds(poiDataEntityList.stream().map(PoiDataEntity::getId).collect(Collectors.toList()));

        Map<String, String> categoryMap = categoryMapper.selectList(null).stream().collect(Collectors.toMap(CategoryEntity::getName, CategoryEntity::getId));

        for (PoiDataEntity poiDataEntity : poiDataEntityList) {
            String category = poiDataEntity.getCategory();
            if (categoryMap.containsKey(category)) {
                poiDataEntity.setCategory(categoryMap.get(category));
            } else {
                poiDataEntity.setCategory("");
            }
            poiDataEntity.setId(null);
        }

        List<BatchResult> insert = poiDataMapper.insert(poiDataEntityList);
        System.out.println(insert);

    }

    @Test
    void genCategoryData() {

        List<CategoryEntity> categoryEntityList = categoryMapper.selectList(null);
        for (CategoryEntity categoryEntity : categoryEntityList) {
            categoryEntity.setId(null);
        }

        List<BatchResult> insert = categoryMapper.insert(categoryEntityList);
        System.out.println(insert);
    }
}