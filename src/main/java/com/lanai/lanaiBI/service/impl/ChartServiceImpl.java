package com.lanai.lanaiBI.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lanai.lanaiBI.constant.CommonConstant;
import com.lanai.lanaiBI.mapper.ChartMapper;
import com.lanai.lanaiBI.model.dto.chart.ChartQueryRequest;
import com.lanai.lanaiBI.model.entity.Chart;
import com.lanai.lanaiBI.service.ChartService;
import com.lanai.lanaiBI.utils.SqlUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author lanai
* @description 针对表【chart(图表信息)】的数据库操作Service实现
* @createDate 2023-11-18 18:40:51
*/
@Service
public class ChartServiceImpl extends ServiceImpl<ChartMapper, Chart>
    implements ChartService{

    /**
     * 获取查询包装类
     *
     * @param chartQueryRequest
     * @return
     */
    @Override
    public QueryWrapper<Chart> getQueryWrapper(ChartQueryRequest chartQueryRequest) {
        QueryWrapper<Chart> queryWrapper = new QueryWrapper<>();
        if (chartQueryRequest == null) {
            return queryWrapper;
        }
        String sortField = chartQueryRequest.getSortField();
        String sortOrder = chartQueryRequest.getSortOrder();
        Long id = chartQueryRequest.getId();
        String goal = chartQueryRequest.getGoal();
        String name = chartQueryRequest.getName();
        String chartType = chartQueryRequest.getChartType();
        Long userId = chartQueryRequest.getUserId();

        // 拼接查询条件
        queryWrapper.eq(ObjectUtils.isNotEmpty(id), "id", id);
        queryWrapper.like(StringUtils.isNotBlank(name), "name", name);
        queryWrapper.eq(StringUtils.isNotBlank(goal), "goal", goal);
        queryWrapper.eq(StringUtils.isNotBlank(chartType), "chartType", chartType);
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId), "userId", userId);
        queryWrapper.eq("isDelete", false);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }
}




