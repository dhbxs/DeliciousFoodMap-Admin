package delicious.food.map.service;

import delicious.food.map.entity.CategoryEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 分类 服务类
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
public interface CategoryService extends IService<CategoryEntity> {

    /**
     * 获取所有美食分类数据
     *
     * @return 分类数据
     */
    List<CategoryEntity> getAll();

}
