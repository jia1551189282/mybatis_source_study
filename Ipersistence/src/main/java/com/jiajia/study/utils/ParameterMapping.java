package com.jiajia.study.utils;

import lombok.Data;

/**
 * @author zjiajia
 * @date 2020/8/22 23:21
 */


@Data
public class ParameterMapping {

    private String content;


    public ParameterMapping(String content){
        this.content =content;
    }


}
