package com.lanai.lanaiBI.model.vo;

import lombok.Data;

/**
 * @BelongsProject: lanaiBI
 * @CreateTime: 2023-12-25  11:03
 * @Author: lanai
 * @Description: AI 分析返回结果
 */
@Data
public class BiResponse {
    private String genChart;
    private String genResult;
    private long chartId;
}
