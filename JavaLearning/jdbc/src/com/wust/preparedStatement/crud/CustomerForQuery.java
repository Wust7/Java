package com.wust.preparedStatement.crud;

import com.wust.bean.Customer;
import com.wust.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * 针对customers表的查询操作
 */
public class CustomerForQuery {
    @Test
    public void testQuery2(){
        String sql = "select id,name,birth,email from customers where id = ?";
        System.out.println(queryForCustomers(sql, 1));
        String sql2 = "select birth,email from customers where name = ?";
        System.out.println(queryForCustomers(sql2, "周杰伦"));
    }
    /**
     * 针对Customer的通用查询
     */
    public Customer queryForCustomers(String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果列数
            int columnCount = rsmd.getColumnCount();
            Customer cus = new Customer();
            if(rs.next()){
                //处理结果中一行数据的每一列
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i+1);
                    //获取列名  --- 不建议使用   -- 建议使用rsmd.getColumnLabel()
                    String columnName = rsmd.getColumnName(i + 1);

                    //给cus对象指定的columnName属性，赋值为columnValue，通过反射  -- field指向字段
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);//使得私有的也可以访问
                    field.set(cus,columnValue);
                }
                return cus;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }
    @Test
    public void testQuery1(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth from customers where id = 1";
            ps = conn.prepareStatement(sql);

            //执行并返回结果集，查询到的该结果也需要关闭
            resultSet = ps.executeQuery();

            //处理结果集合
            if(resultSet.next()){// 判断结果集的下一条是否有数据
                //获取当前数据的各个字段
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                //方式一
                Object[] data = new Object[]{id,name,email,birth};
                //方式二
                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.closeResource(conn,ps,resultSet);
        }

    }
}
