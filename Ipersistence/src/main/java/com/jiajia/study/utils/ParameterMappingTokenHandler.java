package com.jiajia.study.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjiajia
 * @date 2020/8/22 23:19
 */

@Data
public class ParameterMappingTokenHandler implements TokenHandler{

    private List<ParameterMapping> parameterMappings = new ArrayList<>();

    @Override
    public String handleToken(String content) {
        parameterMappings.add(buildParameterMapping(content));
        return "?";
    }

    private ParameterMapping buildParameterMapping(String content) {
        ParameterMapping parameterMapping = new ParameterMapping(content);
        return parameterMapping;
    }
}
