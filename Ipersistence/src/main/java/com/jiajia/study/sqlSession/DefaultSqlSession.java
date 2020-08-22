package com.jiajia.study.sqlSession;

import com.jiajia.study.pojo.Configuration;
import com.jiajia.study.pojo.MappedStatement;

import java.util.List;

/**
 * @author zjiajia
 * @date 2020/8/22 13:36
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;


    public DefaultSqlSession(Configuration configuration){
        this.configuration =  configuration;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object... params) {
        Executor executor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
        List<Object> list = executor.query(configuration, mappedStatement, params);

        return (List<E>) list;
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) {
        List<Object> list = selectList(statementId, params);
        if(list.size() == 1){
            return (T) list.get(0);
        }else {
            throw new RuntimeException("查询结果异常");
        }
    }
}
