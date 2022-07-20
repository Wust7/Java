package com.wust.statement.crud;

import com.wust.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * 使用preparedStatement解决sql注入问题
 * 1.除了解决Statement的拼串、sql诸如问题
 * 2.PreparedStatement能操作Blob数据，而Statement不行
 * 3.PreparedStatement批量处理更加高效
 */
public class PreparedStatementTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("用户名：");
        String user = sc.nextLine();
        System.out.println("密码：");
        String password = sc.nextLine();
//		select user,password from user_table where user = '1' or ' and password = '=1 or '1' = '1';
        String sql = "select user,password from user_table where user = ? and password = ?";
        User returnUser = getInstance(User.class,sql,user,password);
        if(returnUser != null){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }
    }

    /**
     * 通用查询语句  : 返回表中一条记录
     * @param clazz 类型
     * @param sql 查询语句
     * @param args 不确定占位符
     * @param <T> 表示泛型方法
     * @return
     */
    public static <T>T getInstance(Class<T> clazz,String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            //通过此处预编译固定sql语句含义 -- 后面的sql注入无法改变这种关系
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


}
