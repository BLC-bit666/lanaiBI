package com.lanai.lanaiBI.utils;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @BelongsProject: lanaiBI
 * @CreateTime: 2023-12-19  20:36
 * @Author: lanai
 * @Description: Excel 处理
 */
@Slf4j
public class ExcelUtils {
    public static String excelToCsv(MultipartFile multipartFile) {
        /*File file = null;
        try {
            file = ResourceUtils.getFile("classpath:UserData.xlsx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }*/
        List<Map<Integer, String>> list = null;
        try {
            list = EasyExcel.read(multipartFile.getInputStream())
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet()
                    .headRowNumber(0)
                    .doReadSync();
        } catch (IOException e) {
            log.error("Csv读取错误",e);
            throw new RuntimeException(e);
        }
        if(CollUtil.isEmpty(list)){
            return "";
        }
        // 创建缓冲区用于合并所有数据
        StringBuffer buffer = new StringBuffer();

        // 取表头
        LinkedHashMap<Integer, String> headMap = (LinkedHashMap<Integer, String>) list.get(0);
        List<String> headList = headMap.values().stream().filter(StringUtils::isNotEmpty).collect(Collectors.toList());
        buffer.append(StringUtils.join(headList, ",")).append("\n");

        // 取数据
        for (int i = 1; i < list.size(); i++) {
            LinkedHashMap<Integer, String> dataMap = (LinkedHashMap<Integer, String>) list.get(i);
            List<String> dataList = dataMap.values().stream().filter(StringUtils::isNotEmpty).collect(Collectors.toList());
            buffer.append(StringUtils.join(dataList, ",")).append("\n");
        }
        return buffer.toString();
    }
}
