package com.JdbcTemplate.dao;


import com.JdbcTemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//第三步：创建对象，并注入JdbcTemplate
@Repository
public class BookDaoImpl implements BookDao{

    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate; //通过该Template实现数据库的CRUD

    @Override
    public void add(Book book) {
        //创建SQL语句
        String sql = "insert into book(id, username, userstatus) VALUES (?,?,?)";
        Object[] args = {book.getId(), book.getUserName(), book.getUserStatus()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    @Override
    public void delete(String id) {
        //创建SQL语句
        String sql = "update book set  VALUES (?,?,?)";
        Object[] args = {book.getId(), book.getUserName(), book.getUserStatus()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    @Override
    public void update(Book book) {

    }
}
