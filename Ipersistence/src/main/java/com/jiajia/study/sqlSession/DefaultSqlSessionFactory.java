package com.jiajia.study.sqlSession;

import com.jiajia.study.pojo.Configuration;

/**
 * @author zjiajia
 * @date 2020/8/22 13:33
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration){
        this.configuration =configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
