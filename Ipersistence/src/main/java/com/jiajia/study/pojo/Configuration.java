package com.jiajia.study.pojo;

import lombok.Data;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zjiajia
 * @date 2020/8/22 11:13
 *
 * 解析出来的 总的配置文件的 封装
 */

@Data
public class Configuration {

    /**
     * 数据源的封装
     */
    private DataSource dataSource;

    /**
     * 每一个  mappedStament  保存在map 中
     */
    Map<String,MappedStatement> mappedStatementMap = new HashMap<>();
}
