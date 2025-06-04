package delicious.food.map.controller;


import delicious.food.map.common.JsonResult;
import delicious.food.map.entity.CategoryEntity;
import delicious.food.map.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public JsonResult<List<CategoryEntity>> getAll() {
        List<CategoryEntity> result = categoryService.getAll();
        return JsonResult.success(result);
    }


}
