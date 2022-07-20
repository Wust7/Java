package com.wust.blob;

import com.wust.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 使用PreparedStatement实现批量数据操作
 *
 * update、delete本身就具有批量操作的效果
 *
 * 此时的批量操作，主要指的是批量插入。使用PreparedStatement实现高效批量操作
 *
 *
 *create table goods(
 *     id int primary key auto_increment,
 *     name varchar(25)
 * );
 *
 */
public class InsertTest {
    /**
     * 方式一：
     */
    @Test
    public void testInsert1(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            String sql = "insert into goods(name)values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < 100; i++) {
                ps.setObject(1,"name_"+i);
                ps.execute();
            }
            long end = System.currentTimeMillis();
            System.out.println(end-start);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
    }
    /**
     * 方式二 速度快
     * 1.addBatch()、executeBatch()、clearBatch()
     * 2.mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持
     *          &&rewriteBatchedStatements=true
     */
    @Test
    public void testInsert2(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            String sql = "insert into goods(name)values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 100; i++) {
                ps.setObject(1,"name_"+i);
//                ps.execute();

                //1."攒"sql
                ps.addBatch();
                if(i%50 == 0){
                    //2.执行
                    ps.executeBatch();
                    //3.清空batch
                    ps.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println(end-start);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
    }
    /**
     * 方式四 速度更快
     * 设置不允许自动提交，通过统一提交来实现
     */
    @Test
    public void testInsert3(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();

            //设置不允许自动提交数据
            conn.setAutoCommit(false);

            String sql = "insert into goods(name)values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 100; i++) {
                ps.setObject(1,"name_"+i);
//                ps.execute();

                //1."攒"sql
                ps.addBatch();
                if(i%50 == 0){
                    //2.执行
                    ps.executeBatch();
                    //3.清空batch
                    ps.clearBatch();
                }
            }
            //统一提交
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println(end-start);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
    }
}
