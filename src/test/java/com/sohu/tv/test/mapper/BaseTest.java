package com.sohu.tv.test.mapper;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

/**
 * mybatis测试基类
 * @author leifu
 * @Date 2016-2-8
 * @Time 下午10:47:04
 */
public class BaseTest {
    
    protected static SqlSessionFactory sessionFactory;
    
    @BeforeClass
    public static void setup() throws IOException {
        String resource = "mybatis-base.xml";
        // 加载mybatis的配置文件（它也加载关联的映射文件）
        Reader reader = Resources.getResourceAsReader(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }
}
