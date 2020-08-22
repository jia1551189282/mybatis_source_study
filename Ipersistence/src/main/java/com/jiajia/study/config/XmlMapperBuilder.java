package com.jiajia.study.config;

import com.jiajia.study.pojo.Configuration;
import com.jiajia.study.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @author zjiajia
 * @date 2020/8/22 12:20
 */
public class XmlMapperBuilder {

    private Configuration configuration;

    public XmlMapperBuilder(Configuration configuration){
        this.configuration = configuration;
    }

    /**
     * 解析 mapper.xml  文件 并放到  configuration 中去
     * @param inputStream  mapper.xml 加载成的输入流
     */
    public void parse(InputStream inputStream) throws DocumentException {
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();
        // 获取  到 namespace   后面 拼装 statementId
        String namespace = rootElement.attributeValue("namespace");

        List<Element> listElement = rootElement.selectNodes("//select");

        for (Element element: listElement
             ) {
            String resultType = element.attributeValue("resultType");
            String parameterType = element.attributeValue("parameterType");
            String id = element.attributeValue("id");
            String sql = element.getTextTrim();

            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParamterType(parameterType);
            mappedStatement.setSql(sql);
            // 将 mapstatement  设置到 configuration 中去
            configuration.getMappedStatementMap().put(namespace + "." + id ,mappedStatement);
        }
    }
}
