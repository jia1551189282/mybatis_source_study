package com.jiajia.study.sqlSession;

import com.jiajia.study.config.XmlConfigBuilder;
import com.jiajia.study.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @author zjiajia
 * @date 2020/8/22 11:42
 */
public class SqlSessionFactoryBuilder {
        public SqlSessionFactory build(InputStream inputStream) throws PropertyVetoException, DocumentException {

            // 使用dom4j 解析配置文件，将解析的配置文件封装到configuration中
            XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder();
            Configuration configuration = xmlConfigBuilder.parseConfig(inputStream);

            //创建sqlSessionFactory 对象
            return new DefaultSqlSessionFactory(configuration);





        }

}
