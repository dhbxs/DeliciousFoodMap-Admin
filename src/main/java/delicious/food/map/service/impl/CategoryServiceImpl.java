package delicious.food.map.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import delicious.food.map.common.StatusCode;
import delicious.food.map.entity.CategoryEntity;
import delicious.food.map.exception.BusinessException;
import delicious.food.map.mapper.CategoryMapper;
import delicious.food.map.model.CategoryResultModel;
import delicious.food.map.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类 服务实现类
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity> implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 获取所有美食分类数据 - 包含该分类下的美食数据量
     *
     * @return 分类数据
     */
    @Override
    public List<CategoryResultModel> getAll() {

        return categoryMapper.getAllCategoryData();
    }

    /**
     * 新增或更新分类数据
     * 有ID则更新 无则ID或ID不存在则新增
     * isDelete 值为Y则删除 值为空或值为N则不删除
     *
     * @param categoryEntity 分类数据
     * @return 执行结果
     */
    @Override
    public boolean insertOrUpdateOrDeleteCategory(CategoryEntity categoryEntity) {
        if (StringUtils.equals(categoryEntity.getIsDelete(), "Y") && StringUtils.isBlank(categoryEntity.getId())) {
            throw new BusinessException(StatusCode.PARAMS_ERROR, "删除时必须指定分类ID");
        }
        // 如果没有指定删除状态，默认为 N - 未删除
        if (StringUtils.isBlank(categoryEntity.getIsDelete())) {
            categoryEntity.setIsDelete("N");
        }
        return categoryMapper.insertOrUpdate(categoryEntity);
    }
}
