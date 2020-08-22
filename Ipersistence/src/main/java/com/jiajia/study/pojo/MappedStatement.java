package com.jiajia.study.pojo;

import lombok.Data;

/**
 * @author zjiajia
 * @date 2020/8/22 11:09
 *
 * 对mapper解析出来的标签进行封装
 */


@Data
public class MappedStatement {

    /**
     * id 标识， 即stamentId ：namespace + id
     */
    private String id;
    /**
     * 返回值类型
     */
    private String resultType;
    /**
     * 参数类型
     */
    private String paramterType;
    /**
     * sql语句
     */
    private String sql;




}
