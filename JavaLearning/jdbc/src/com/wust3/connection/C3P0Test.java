package com.wust3.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;

import java.sql.Connection;

/**
 *
 */
public class C3P0Test {
    //方式一
    @Test
    public void testGetConnection1()throws Exception{
        //获取吃c3p0数据库连接池
        ComboPooledDataSource cpds= new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        cpds.setUser("root");
        cpds.setPassword("1234");

        //设置初始时数据库连接池中连接数
        cpds.setInitialPoolSize(10);

        Connection conn = cpds.getConnection();
        System.out.println(conn);

//        //销毁连接池  --一般不销毁
//        DataSources.destroy(cpds);
    }

    //方法二：配置文件
    @Test
    public void testGetConnection2()throws Exception{
        //通过调用c3p0-config.xml配置文件来读取参数
        ComboPooledDataSource cpds = new ComboPooledDataSource("hellc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }
}
