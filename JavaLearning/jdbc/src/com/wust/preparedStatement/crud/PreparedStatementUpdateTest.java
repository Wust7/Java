package com.wust.preparedStatement.crud;

import com.wust.util.JDBCUtils;
import org.junit.Test;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

/**
 * 使用PreparedStatement来替换Statement，实现对数据表的增删改查操作
 * <p>
 * 增删改；查
 */
public class PreparedStatementUpdateTest {
//    public

    @Test
    public void testCommonUpdate(){
//        String sql = "delete from customers where id = ?";
//        update(sql,3);
        /**
         * You have an error in your SQL syntax
         * order是个表名，同时也是关键字，所以会报错
         */
//        String sql = "update `order` set order_name = ? where order_id = ?";
//        update(sql,"DD",2);
        String sql = "insert into customers(name, email, birth) VALUES (?,?,?)";
        String name = "JYQ";
        String email = "万松园";
        String birth = "1998-04-14";
        int insertCount = update(sql, name, email, birth);
        System.out.println(insertCount);

    }
    /**
     * 通用的增删改
     * ...args :可变形参
     *
     * !!! @Test下面的方法不能有形参
     */
    public int update(String sql,Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0;i<args.length;i++) {
                ps.setObject(i+1,args[i]);//小心参数声明
            }
            /**
             * ps.execute()
             * 如果执行查询操作，有返回结果则返回true
             * 如果执行增删改操作，没有返回结果，怎返回false
             */
//            ps.execute();
            /**
             * either (1) the row count for SQL Data Manipulation Language (DML) statements
             * (2) 0 for SQL statements that return nothing
             */
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
        return 0;
    }

    /**
     * 修改customer表中得一条数据
     */
    @Test
    public void testUpdate() {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            //获取数据库连接
            conn = JDBCUtils.getConnection();
            //预编译sql语句
            String sql = "update customers set name = ? where id = ?";
            ps = conn.prepareStatement(sql);
            //填充占位符
            ps.setObject(1, "WST");
            ps.setObject(2, 19);
            //执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            JDBCUtils.closeResource(conn,ps);
        }
    }

    /**
     * 向customer表中添加一条数据
     */
    @Test
    public void testInsert() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //读取配置文件
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

            Properties pros = new Properties();
            pros.load(is);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");

            //加载驱动
            Class.forName(driverClass);

            //获取连接
            conn = DriverManager.getConnection(url, user, password);

            System.out.println(conn);

            //预编译sql语句
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            ps = conn.prepareStatement(sql);

            //填充占位符
            ps.setString(1, "JYQ");
            ps.setString(2, "12324@qq.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("1998-04-14");
            ps.setDate(3, new java.sql.Date(date.getTime()));

            //执行操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }


}
