package com.jiajia.study.sqlSession;

import com.jiajia.study.pojo.Configuration;
import com.jiajia.study.pojo.MappedStatement;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zjiajia
 * @date 2020/8/22 16:28
 */
public interface Executor {

    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement,Object...params) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException;
}
