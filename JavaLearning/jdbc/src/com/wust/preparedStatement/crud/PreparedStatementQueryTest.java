package com.wust.preparedStatement.crud;

import com.wust.bean.Order;
import com.wust.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 针对不同表的查询语句
 */

public class PreparedStatementQueryTest {
    @Test
    public void testQuery(){
//        String sql = "select order_id orderId, order_name orderName, order_date orderDate from `order` where order_id = ?";
//        Order order = getInstance(Order.class, sql,1);
//        System.out.println(order);
        String sql = "select order_id orderId, order_name orderName, order_date orderDate from `order` where order_id < ?";
//        System.out.println(getForList(Order.class, sql, 10));
        getForList(Order.class,sql,10).forEach(System.out::println);

        String sql2 = "select order_id orderId, order_name orderName, order_date orderDate from `order`";
        getForList(Order.class,sql2).forEach(System.out::println);
    }

    /**
     * 通用查询语句  : 返回表中一条记录
     * @param clazz 类型
     * @param sql 查询语句
     * @param args 不确定占位符
     * @param <T> 表示泛型方法
     * @return
     */
    public <T>T getInstance(Class<T> clazz,String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
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
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    /**
     * 通用查询语句  : 返回表中所有记录
     * @param clazz 类型
     * @param sql 查询语句
     * @param args 不确定占位符
     * @param <T> 表示泛型方法
     * @return
     */
    public <T> List<T> getForList(Class<T> clazz, String sql, Object... args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
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
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }
}
