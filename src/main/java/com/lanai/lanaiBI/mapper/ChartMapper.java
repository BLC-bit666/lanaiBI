package com.lanai.lanaiBI.mapper;

import com.lanai.lanaiBI.model.entity.Chart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
* @author lanai
* @description 针对表【chart(图表信息)】的数据库操作Mapper
* @createDate 2023-11-18 18:40:51
* @Entity com.lanai.lanaiBI.model.entity.Chart
*/
public interface ChartMapper extends BaseMapper<Chart> {

    /**
     * 自定义方法，用于实现自定义 sql
     * @param querySql
     * @return
     */
    List<Map<String,Object>> queryChartData(String querySql);
}




