package com.wust.blob;

import com.wust.bean.Customer;
import com.wust.util.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * PreparedStatement操作Blob
 */
public class BlobTest {
    //Customers中插入Blob类型的字段
    @Test
    public void testInsert()throws Exception{
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into customers(name,email,birth,photo) values (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1,"XCG");
        ps.setObject(2,"CUG");
        ps.setObject(3,"2024-01-01");
        FileInputStream fis = new FileInputStream(new File("D:\\GitCode\\Java\\JavaLearning\\jdbc\\src\\com\\wust\\blob\\2.jpg"));
        ps.setBlob(4,fis);
        ps.execute();
        JDBCUtils.closeResource(conn,ps);
    }

    @Test
    public void testQuery(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id, name,email, birth, photo from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,22);
            rs = ps.executeQuery();
            if(rs.next()){
                //方法一
    //            int id = rs.getInt(1);
    //            String name = rs.getString(2);
    //            String email = rs.getString(3);
    //            Date birth = rs.getDate(4);

                //方法二
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");
                Customer cust = new Customer(id, name, email, birth);
                System.out.println("**"+cust);

                //下载Blob类型数据并保存本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream("xcg.jpg");
                byte[] bys = new byte[1024];
                int len;
                while((len = is.read(bys))!=-1){
                    fos.write(bys,0,len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(is!=null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn,ps,rs);
        }
    }
}
