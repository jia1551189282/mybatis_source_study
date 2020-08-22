package com.jiajia.study.config;

import com.jiajia.study.io.Resources;
import com.jiajia.study.pojo.Configuration;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author zjiajia
 * @date 2020/8/22 11:46
 */
public class XmlConfigBuilder {

    private Configuration configuration;

    public XmlConfigBuilder(){
        this.configuration = new Configuration();
    }

    /**
     * 使用 dom4j 对配置文件进行解析，封装到configuration 中去
     * @param inputStream
     * @return
     */
    public Configuration parseConfig(InputStream inputStream) throws DocumentException, PropertyVetoException {

        //
        Document document = new SAXReader().read(inputStream);
        // 获取到根节点
        Element rootElement = document.getRootElement();
        List<Element> list = rootElement.selectNodes("//property");
        Properties properties = new Properties();
        // 将 property  中的name 和 value 值保存到properties 中去
        for (Element element : list) {
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.setProperty(name,value);

        }
        //  创建数据源，并将 xml 中数据源的配置信息 设置到 数据源中
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(properties.getProperty("driverClass"));
        comboPooledDataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
        comboPooledDataSource.setUser(properties.getProperty("username"));
        comboPooledDataSource.setPassword(properties.getProperty("password"));

        // 将数据源封装到 configuration 中
        configuration.setDataSource(comboPooledDataSource);

        // 解析 mapper.xml
        XmlMapperBuilder xmlMapperBuilder = new XmlMapperBuilder(configuration);

        List<Element> mapperList = rootElement.selectNodes("//mapper");
        for (Element element: mapperList
             ) {
            String resource = element.attributeValue("resource");
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            xmlMapperBuilder.parse(resourceAsStream);
        }


        return configuration;
    }
}
