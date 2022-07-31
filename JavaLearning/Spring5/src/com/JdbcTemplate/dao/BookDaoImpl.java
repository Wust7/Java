package com.JdbcTemplate.dao;


import com.JdbcTemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

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
    public void update(Book book) {
        //创建SQL语句
        String sql = "update book set userName=?,userStatus=? where id = ?";
        Object[] args = {book.getUserName(), book.getUserStatus(),book.getId()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    @Override
    public void delete(String id) {
        //创建SQL语句
        String sql = "delete from book where id = ?";
        int update = jdbcTemplate.update(sql,id);
        System.out.println(update);
    }

    @Override
    public int selectCount() {
        String sql = "select Count(*) from book";
        /**
         * queryForObject(String sql, Class<T> requiredType) 查询返回单个值的表查询语句
         * sql 指定查询语句
         * requiredType 指定数据返回类型
         */
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from book where id=?";
        /**
         * queryForObject(String var1, RowMapper<T> var2, @Nullable Object... var3)
         * var1 sql 查询语句
         * var2 RowMapper 接口  使用这个接口里面实现类来完成数据封装
         * var3 sql语句值 ，问号处该填的
         */
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> findAllBookInfo() {
        String sql = "select * from book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into book(id, username, userstatus) VALUES (?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        String sql = "update book set userName=?,userStatus=? where id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {
        String sql = "delete from book where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}
