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

    /**
     * 新增或更新分类数据
     * 有ID则更新 无则ID或ID不存在则新增
     * isDelete 值为Y则删除 值为空或值为N则不删除
     *
     * @param categoryEntity 分类数据
     * @return 执行结果
     */
    boolean insertOrUpdateOrDeleteCategory(CategoryEntity categoryEntity);
}
