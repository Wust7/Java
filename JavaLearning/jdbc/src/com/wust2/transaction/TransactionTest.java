package com.wust2.transaction;

import com.wust.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * 事务处理原则：
 *      一个事务中的操作要么都执行要么都不执行
 */
public class TransactionTest {

    /**
     * 针对user_table:
     * AA用户给BB用户转账100
     * update user_table set balance = balance -100 where user = 'AA'
     * update user_table set balance = balance +100 where user = 'BB'
     *
     * 自动提交情况：
     *      DDL操作一旦执行，都会自动提交
     *      DML默认情况下，一旦执行，就会自动提交，可以通过setAutocommit = false的方式取消DML操作的自动提交，
     *      默认在关闭时，就会自动提交数据
     */
    @Test
    public void testUpdate(){
        String sql1 = "update user_table set balance = balance -100 where user = ?";
        update(sql1,"AA");
        //模拟异常     ---  上面的sql1执行，下面的sql2不执行
        System.out.println(10/0);
        String sql2 = "update user_table set balance = balance +100 where user = ?";
        update(sql2,"BB");
    }
    /**
     * 考虑事务的转账操作
     */
    @Test
    public void testUpdateWithTx(){
        Connection conn = null;
        try {
            //默认在关闭时，就会自动提交数据,故把关闭拿出来统一关闭
            conn = JDBCUtils.getConnection();
            System.out.println(conn.getAutoCommit());

            //取消DML操作的自动提交
            conn.setAutoCommit(false);
            String sql1 = "update user_table set balance = balance -100 where user = ?";
            update(conn,sql1,"AA");

            //模拟异常     ---  上面的sql1执行，下面的sql2不执行
            System.out.println(10/0);

            String sql2 = "update user_table set balance = balance +100 where user = ?";
            update(conn,sql2,"BB");

            //统一提交DML操作
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //出现异常回滚数据
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                //针对于使用数据库连接池中，需要归还连接，上面的置false，会使得该连接默认为false，故需要更改回原来true
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void testTransactionSelect()throws Exception{
        Connection conn = JDBCUtils.getConnection();

        //获取连接隔离级别
        System.out.println(conn.getTransactionIsolation());
        //设置数据库隔离级别
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        //取消自动提交
        conn.setAutoCommit(false);

        String sql = "select user,password,balance from user_table where user = ?";
        User user = getInstance(conn, User.class, sql, "CC");
        System.out.println(user);
    }
    @Test
    public void testTransactionUpdate()throws Exception{
        Connection conn = JDBCUtils.getConnection();
        //取消自动提交
        conn.setAutoCommit(false);
        String sql = "update user_table set balance = ? where user = ?";
        int num = update(conn, sql, 5000,"CC");
        Thread.sleep(15000);
        System.out.println("修改结束");
    }
    /**
     * 通用的增删改 version1.0
     * 未考虑事务操作
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
     * 通用的增删改 version2.0
     * 考虑事务操作
     * ...args :可变形参
     *
     * !!! @Test下面的方法不能有形参
     */
    public int update(Connection conn, String sql,Object ...args) {
        PreparedStatement ps = null;
        try {
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
            JDBCUtils.closeResource(null,ps);
        }
        return 0;
    }

    /**
     * 通用查询语句  : 返回表中一条记录  version2.0 考虑了事务
     * @param clazz 类型
     * @param sql 查询语句
     * @param args 不确定占位符
     * @param <T> 表示泛型方法
     * @return
     */
    public <T>T getInstance(Connection conn, Class<T> clazz,String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    //获取列名  -- 不建议使用
//                    String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }
}
