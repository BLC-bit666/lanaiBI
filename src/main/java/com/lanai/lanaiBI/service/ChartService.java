package com.lanai.lanaiBI.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.lanai.lanaiBI.model.dto.chart.ChartQueryRequest;
import com.lanai.lanaiBI.model.entity.Chart;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lanai
* @description 针对表【chart(图表信息)】的数据库操作Service
* @createDate 2023-11-18 18:40:51
*/
public interface ChartService extends IService<Chart> {

    Wrapper<Chart> getQueryWrapper(ChartQueryRequest chartQueryRequest);
}
