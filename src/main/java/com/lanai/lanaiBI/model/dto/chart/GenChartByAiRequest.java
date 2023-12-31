package com.lanai.lanaiBI.model.dto.chart;

import lombok.Data;

import java.io.Serializable;

/**
 * @BelongsProject: lanaiBI
 * @CreateTime: 2023-12-19  19:43
 * @Author: lanai
 * @Description: TODO
 */
@Data
public class GenChartByAiRequest implements Serializable {

    /**
     * 图表名称
     */
    private String name;

    /**
     * 分析目标
     */
    private String goal;

    /**
     * 图表类型
     */
    private String chartType;


    private static final long serialVersionUID = 1L;
}
