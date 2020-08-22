package com.jiajia.study.sqlSession;

import java.util.List;

/**
 * @author zjiajia
 * @date 2020/8/22 13:35
 */
public interface SqlSession {
    /**
     * 查询所有
     * @param statementId   namespace + id
     * @param params        可变参数
     * @param <E>           泛型
     * @return              返回
     */
     <E> List<E> selectList(String statementId, Object... params);

    /**
     * 按条件查询单个
     * @param statementId   namespace + id
     * @param params        可变参数
     * @param <T>           泛型
     * @return              返回结果
     */
     <T> T selectOne(String statementId,Object... params);
}
