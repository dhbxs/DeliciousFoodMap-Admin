package delicious.food.map.controller;


import delicious.food.map.common.JsonResult;
import delicious.food.map.common.RoleConstant;
import delicious.food.map.config.aop.AuthCheck;
import delicious.food.map.config.aop.RateLimit;
import delicious.food.map.entity.CategoryEntity;
import delicious.food.map.model.CategoryResultModel;
import delicious.food.map.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 分类 前端控制器
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 获取美食分类数据
     *
     * @return 分类数据
     */
    @PostMapping("/get-all")
    @RateLimit(key = "publicInterface", permitsPerSecond = 100, timeout = 500)
    public JsonResult<List<CategoryResultModel>> getAllCategoryData() {
        List<CategoryResultModel> result = categoryService.getAll();
        return JsonResult.success(result);
    }

    /**
     * 美食分类数据 增删改接口
     * 有ID则更新 无则ID或ID不存在则新增
     * isDelete 值为Y则删除 值为空或值为N则不删除
     *
     * @param category 分类数据
     * @return 执行结果
     */
    @PostMapping("/insert-or-update-or-delete")
    @RateLimit(key = "sysInterface", permitsPerSecond = 50, timeout = 500)
    @AuthCheck(role = {RoleConstant.USER, RoleConstant.ADMIN})
    public JsonResult<Boolean> insertOrUpdateOrDeleteCategory(@RequestBody CategoryEntity category) {
        boolean result = categoryService.insertOrUpdateOrDeleteCategory(category);
        return JsonResult.success(result);
    }
}
