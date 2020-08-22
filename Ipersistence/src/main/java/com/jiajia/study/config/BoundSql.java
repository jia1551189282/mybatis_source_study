package com.jiajia.study.config;

import com.jiajia.study.utils.ParameterMapping;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjiajia
 * @date 2020/8/23 0:05
 */

@Data
public class BoundSql {
    /**
     * 解析后的sql
     */
    private String sqlText;
    /**
     * 参数
     */
    private List<ParameterMapping> parameterMappingList = new ArrayList<>();


    public BoundSql(String sqlText,List<ParameterMapping> parameterMappingList){
        this.sqlText = sqlText;
        this.parameterMappingList = parameterMappingList;
    }


}
