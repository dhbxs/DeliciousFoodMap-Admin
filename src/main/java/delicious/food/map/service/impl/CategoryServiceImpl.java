package delicious.food.map.service.impl;

import delicious.food.map.entity.CategoryEntity;
import delicious.food.map.mapper.CategoryMapper;
import delicious.food.map.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
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
     * 获取所有美食分类数据
     *
     * @return 分类数据
     */
    @Override
    public List<CategoryEntity> getAll() {
        return categoryMapper.selectList(null);
    }
}
