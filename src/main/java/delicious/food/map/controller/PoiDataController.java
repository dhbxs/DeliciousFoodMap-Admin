package delicious.food.map.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import delicious.food.map.common.JsonResult;
import delicious.food.map.common.RoleConstant;
import delicious.food.map.common.validator.group.SearchPoiData;
import delicious.food.map.config.aop.AuthCheck;
import delicious.food.map.config.aop.RateLimit;
import delicious.food.map.entity.PoiDataEntity;
import delicious.food.map.model.PoiDataResultModel;
import delicious.food.map.model.PoiDataSearchModel;
import delicious.food.map.service.PoiDataService;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 美食地点数据 前端控制器
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
@RestController
@RequestMapping("/poi-data")
public class PoiDataController {

    @Resource
    PoiDataService poiDataService;

    /**
     * 条件搜索美食数据
     *
     * @param searchModel 搜索条件
     * @return 搜索结果
     */
    @PostMapping("/search")
    @RateLimit(key = "publicInterface", permitsPerSecond = 100, timeout = 500)
    JsonResult<IPage<PoiDataResultModel>> search(@RequestBody @Validated(SearchPoiData.class) PoiDataSearchModel searchModel) {
        IPage<PoiDataResultModel> search = poiDataService.search(searchModel);
        return JsonResult.success(search);
    }

    /**
     * 美食数据 增删改接口
     * 有ID则更新 无则ID或ID不存在则新增
     * isDelete 值为Y则删除 值为空或值为N则不删除
     *
     * @param poiDataEntity 美食数据
     * @return 执行结果
     */
    @PostMapping("/insert-or-update-or-delete")
    @RateLimit(key = "sysInterface", permitsPerSecond = 50, timeout = 500)
    @AuthCheck(role = {RoleConstant.USER, RoleConstant.ADMIN})
    JsonResult<Boolean> insertOrUpdateOrDeletePoiData(@RequestBody PoiDataEntity poiDataEntity) {
        boolean result = poiDataService.insertOrUpdateOrDeletePoiData(poiDataEntity);
        return JsonResult.success(result);
    }

}
