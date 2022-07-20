package com.wust3.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    /**
     *使用C3p0数据库连接池技术
     * 同时cpds池全局只需一个，因此需要放在外面设置成private static
     * @return
     * @throws Exception
     */
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("hellc3p0");
    public static Connection getConnection1()throws Exception{
        Connection conn = cpds.getConnection();

        return conn;
    }

    /**
     * 使用DBCP数据库连接池技术获取数据库连接
     * @return
     * @throws Exception
     */
    private static DataSource DBCPsource;
    static {
        try {
            Properties pros = new Properties();
            FileInputStream is = new FileInputStream(new File("src\\dbcp.properties"));
            pros.load(is);
            DBCPsource = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection2()throws Exception{
//        Properties pros = new Properties();
////        //方式一
////        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
//        //方式二
//        FileInputStream is = new FileInputStream(new File("src\\dbcp.properties"));
//        pros.load(is);
//        //创建DBCP数据库连接池，但只需要创建一次，故不能放在函数里面？
//        //因此想到使用静态代码块
//        DataSource source = BasicDataSourceFactory.createDataSource(pros);
        Connection conn = DBCPsource.getConnection();
        return conn;
    }

    /**
     * 使用Druid数据库连接池技术
     */
    private static DataSource Druidsource;
    static {
        try {
            Properties pros = new Properties();
            FileInputStream is = new FileInputStream(new File("src\\druid.properties"));
            pros.load(is);
            Druidsource = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection3()throws Exception{
        Connection conn = Druidsource.getConnection();
        return conn;
    }

    /**
     * 关闭连接和Statement的操作
     * @param conn
     * @param ps
     */
    public static void closeResource(Connection conn, Statement ps){
        //资源关闭
        try{
            if(ps!=null)
                ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(conn!=null)
                conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源
     * @param conn
     * @param ps
     * @param rs
     */
    public static void closeResource(Connection conn, Statement ps, ResultSet rs){
        //资源关闭
        try{
            if(ps!=null)
                ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(conn!=null)
                conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(rs!=null)
                rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 使用dbutils.jar中提供的DbUtils工具类，实现资源的关闭
     * @param conn
     * @param ps
     * @param rs
     */
    public static void closeResource1(Connection conn, Statement ps, ResultSet rs){
//        try {
//            DbUtils.close(conn);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DbUtils.close(ps);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DbUtils.close(rs);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        //等价于
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(rs);
    }
}
