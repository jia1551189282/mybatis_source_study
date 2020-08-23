package com.jiajia.study.test;

import com.jiajia.study.io.Resources;
import com.jiajia.study.sqlSession.SqlSession;
import com.jiajia.study.sqlSession.SqlSessionFactory;
import com.jiajia.study.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;

import java.beans.IntrospectionException;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zjiajia
 * @date 2020/8/22 13:39
 */
public class MybatisTest {

    public static void main(String[] args) throws PropertyVetoException, DocumentException, IllegalAccessException, ClassNotFoundException, IntrospectionException, InstantiationException, SQLException, InvocationTargetException, NoSuchFieldException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);



        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<Object> list = sqlSession.selectList("user.findAll");
        for (Object o: list
             ) {
            System.out.println(o);
        }
    }
}
