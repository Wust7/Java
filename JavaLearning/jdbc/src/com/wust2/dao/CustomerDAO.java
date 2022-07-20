package com.wust2.dao;

import com.wust2.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * 此接口用于规范customers表的常用操作——
 */
public interface CustomerDAO {
    /**
     * 将cust对象添加到数据库中
     * @param conn
     * @param cust
     */
    void insert(Connection conn, Customer cust);

    /**
     * 针对指定id,删除表中的一条记录
     */
    void deleteById(Connection conn,int id);

    /**
     * 针对cust对象修改数据表中数据
     */
    void update(Connection conn, Customer cust);

    /**
     * 针对指定id查询得到对应的Customer对象
     * @param conn
     * @param id
     */
    Customer getCustomerById(Connection conn, int id);

    /**
     * 查询Customers表中所有数据
     * @param conn
     * @return
     */
    List<Customer> getAll(Connection conn);

    /**
     * 返回数据表中的数据条目数
     */
    long getCount(Connection conn);

    /**
     * 返回最大生日
     * @param conn
     * @return
     */
    Date getMaxBirth(Connection conn);
}
