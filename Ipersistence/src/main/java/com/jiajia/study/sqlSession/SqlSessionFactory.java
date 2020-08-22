package com.jiajia.study.sqlSession;

/**
 * @author zjiajia
 * @date 2020/8/22 11:46
 */
public interface SqlSessionFactory {
    /**
     * 创建sqlSession 对象
     */
    public SqlSession openSession();
}
