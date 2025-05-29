package delicious.food.map.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import delicious.food.map.common.JsonResult;
import delicious.food.map.entity.PoiDataEntity;
import delicious.food.map.model.PaginationModel;
import delicious.food.map.service.PoiDataService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 分页获取所有 Poi 数据
     */
    @GetMapping("/get-all")
    JsonResult<List<PoiDataEntity>> getAll(PaginationModel page) {
        List<PoiDataEntity> result = poiDataService.getAll(page);
        return JsonResult.success(result);
    }

}
