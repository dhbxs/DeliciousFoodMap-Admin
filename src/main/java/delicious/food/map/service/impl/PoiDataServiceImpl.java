package delicious.food.map.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import delicious.food.map.common.StatusCode;
import delicious.food.map.entity.PoiDataEntity;
import delicious.food.map.exception.BusinessException;
import delicious.food.map.mapper.PoiDataMapper;
import delicious.food.map.model.PoiDataResultModel;
import delicious.food.map.model.PoiDataSearchModel;
import delicious.food.map.service.PoiDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 美食地点数据 服务实现类
 *
 * @author dhbxs
 * @since 2025-05-29 01:42:03
 */
@Service
public class PoiDataServiceImpl extends ServiceImpl<PoiDataMapper, PoiDataEntity> implements PoiDataService {

    @Resource
    PoiDataMapper poiDataMapper;

    /**
     * 条件搜索所有美食数据
     *
     * @param searchModel 搜索条件
     * @return 搜索结果
     */
    @Override
    public IPage<PoiDataResultModel> search(PoiDataSearchModel searchModel) {
        IPage<PoiDataResultModel> result;
        // 没有分页条件则查询全部数据
        if (StringUtils.isBlank(searchModel.getPageNum()) || StringUtils.isBlank(searchModel.getPageSize())) {
            result = poiDataMapper.search(new Page<>(1, -1), searchModel);
        } else {
            result = poiDataMapper.search(new Page<>(Integer.parseInt(searchModel.getPageNum()), Integer.parseInt(searchModel.getPageSize())), searchModel);
        }

        return result;
    }

    /**
     * 美食数据 增删改业
     * 有ID则更新 无则ID或ID不存在则新增
     * isDelete 值为Y则删除 值为空或值为N则不删除
     *
     * @param poiDataEntity 美食数据
     * @return 执行结果i
     */
    @Override
    public boolean insertOrUpdateOrDeletePoiData(PoiDataEntity poiDataEntity) {
        Date now = new Date();
        if (StringUtils.equals(poiDataEntity.getIsDelete(), "Y") && StringUtils.isBlank(poiDataEntity.getId())) {
            throw new BusinessException(StatusCode.PARAMS_ERROR, "删除时必须指定分类ID");
        }
        // 如果没有指定删除状态，默认为 N - 未删除
        if (StringUtils.isBlank(poiDataEntity.getIsDelete())) {
            poiDataEntity.setIsDelete("N");
        }

        // 设置时间状态字段值
        if (StringUtils.isBlank(poiDataEntity.getId())) {
            poiDataEntity.setCreatedTime(now);
            poiDataEntity.setModifiedTime(now);
        } else {
            poiDataEntity.setModifiedTime(now);
        }

        return poiDataMapper.insertOrUpdate(poiDataEntity);
    }


}
