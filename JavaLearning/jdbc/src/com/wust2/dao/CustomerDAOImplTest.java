package com.wust2.dao;

import com.wust.util.JDBCUtils;
import com.wust2.bean.Customer;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerDAOImplTest {

    private CustomerDAOImpl dao = new CustomerDAOImpl();
    @Test
    public void insert() {
        Connection conn = null;
        Customer cust = null;
        try {
            conn = JDBCUtils.getConnection();
            cust = new Customer(1, "XBB", "2342342@qq.com", new Date(12341234123L));
            dao.insert(conn,cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void deleteById() {
        Connection conn = null;
        Customer cust = null;
        try {
            conn = JDBCUtils.getConnection();
            dao.deleteById(conn,23);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void update() {
        Connection conn = null;
        Customer cust = null;
        try {
            conn = JDBCUtils.getConnection();
            cust = new Customer(21, "XBB", "2342342@qq.com", new Date(12341234123L));
            dao.update(conn,cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void getCustomerById() {
        Connection conn = null;
        Customer cust = null;
        try {
            conn = JDBCUtils.getConnection();
            System.out.println(dao.getCustomerById(conn, 19));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void getAll() {
        Connection conn = null;
        Customer cust = null;
        try {
            conn = JDBCUtils.getConnection();
            List<Customer> list = dao.getAll(conn);
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void getCount() {
        Connection conn = null;
        Customer cust = null;
        try {
            conn = JDBCUtils.getConnection();
            System.out.println(dao.getCount(conn));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void getMaxBirth() {
        Connection conn = null;
        Customer cust = null;
        try {
            conn = JDBCUtils.getConnection();
            System.out.println(dao.getMaxBirth(conn));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
}