package delicious.food.map.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import delicious.food.map.common.JsonResult;
import delicious.food.map.model.PoiDataResultModel;
import delicious.food.map.model.PoiDataSearchModel;
import delicious.food.map.service.PoiDataService;
import jakarta.annotation.Resource;
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
    JsonResult<IPage<PoiDataResultModel>> search(@RequestBody PoiDataSearchModel searchModel) {
        IPage<PoiDataResultModel> search = poiDataService.search(searchModel);
        return JsonResult.success(search);
    }

}
