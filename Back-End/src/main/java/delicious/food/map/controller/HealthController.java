package delicious.food.map.controller;

import delicious.food.map.common.JsonResult;
import org.springframework.web.bind.annotation.*;

/**
 * 健康检查接口
 *
 * @author dhbxs
 * @since 2025-01-13 15:00:24
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    /**
     * 存活检查端点
     *
     * @return 部门列表
     */
    @GetMapping("/check")
    public JsonResult<Integer> healthCheck() {
        return JsonResult.success();
    }

}
