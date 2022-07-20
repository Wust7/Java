package com.wust.connection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
    @Test
    public void testConnection1() throws SQLException {
        // 加载第三方数据库：mysql
        Driver driver = new com.mysql.cj.jdbc.Driver();
//        尝试使数据库连接到给定的URL
        // jdbc:协议
        // mysql:子协议 用于表示一个数据库驱动程序
        // localhost:3306/test:子名称 用于定位数据库   格式：主机名（ip地址）,端口号,数据库名
//        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&serverTimezone=UTC";
        String url = "jdbc:mysql://localhost:3306";
        //将用户名和密码封装在Properties
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","1234");
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

    //方式而：对方式一的迭代 :可移植性强
    @Test
    public void testConnection2() throws Exception {
        Class<?> cls = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)cls.newInstance();
        String url = "jdbc:mysql://localhost:3306";
        //将用户名和密码封装在Properties
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","1234");
        Connection con = driver.connect(url, info);
        System.out.println(con);
    }

    //方式三：使用DriverManager替换Driver
    @Test
    public void testConnection3() throws Exception {
        Class<?> cls = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)cls.newInstance();
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "1234";
        //注册驱动
        DriverManager.registerDriver(driver);

        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    //方式四：使用DriverManager替换Driver
    @Test
    public void testConnection4() throws Exception {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "1234";
        /**
         * 可以省略的原因：
         * //        Class<?> cls = Class.forName("com.mysql.cj.jdbc.Driver");
         * //        Driver driver = (Driver)cls.newInstance();
         * //        //注册驱动
         * //        DriverManager.registerDriver(driver);
         * mysql的Driver实现类中声明了如下操作
         * static {
         *         try {
         *             DriverManager.registerDriver(new Driver());
         *         } catch (SQLException var1) {
         *             throw new RuntimeException("Can't register driver!");
         *         }
         *     }
         */
        // 下面一步也可以省，但最好不省略
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    /**
     * 方式五：将数据库需要的4哥基本信息声明在配置文件中，通过读取配置文件来获取连接
     * 好处：
     *  1.实现代码与数据分离。--- 解耦
     *  2.如果需要修改配置文件信息，可以避免程序重新打包
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void testConnection5() throws IOException, ClassNotFoundException, SQLException {
        //读取配置文件信息 -- 通过系统类加载器
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        // 加载驱动
        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }
}
