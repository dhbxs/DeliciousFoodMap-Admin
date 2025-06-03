package delicious.food.map.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import delicious.food.map.entity.PoiDataEntity;
import delicious.food.map.mapper.PoiDataMapper;
import delicious.food.map.model.PaginationModel;
import delicious.food.map.model.PoiDataResultModel;
import delicious.food.map.model.PoiDataSearchModel;
import delicious.food.map.service.PoiDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * 分页获取所有 Poi 数据
     *
     * @param paginationModel 分页信息
     */
    @Override
    public List<PoiDataEntity> getAll(PaginationModel paginationModel) {
        IPage<PoiDataEntity> page;
        if (paginationModel.getPageNum() == null || paginationModel.getPageSize() == null) {
            page = new Page<>(1, 100);
        } else {
            page = new Page<>(Integer.parseInt(paginationModel.getPageNum()), Integer.parseInt(paginationModel.getPageSize()));
        }
        List<PoiDataEntity> poiDataEntityList = poiDataMapper.selectList(page, null);
        return poiDataEntityList;
    }

    /**
     * 条件搜索所有美食数据
     *
     * @param searchModel
     */
    @Override
    public IPage<PoiDataResultModel> search(PoiDataSearchModel searchModel) {
        IPage<PoiDataResultModel> result;
        if (StringUtils.isBlank(searchModel.getPageNum()) || StringUtils.isBlank(searchModel.getPageSize())) {
            result = poiDataMapper.search(new Page<>(1, 100), searchModel);
        } else {
            result = poiDataMapper.search(new Page<>(Integer.parseInt(searchModel.getPageNum()), Integer.parseInt(searchModel.getPageSize())), searchModel);
        }

        return result;
    }
}
