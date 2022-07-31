package com.JdbcTemplate.service;

import com.JdbcTemplate.dao.BookDao;
import com.JdbcTemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//第三步：创建service对象，并 注入dao
@Service
public class BookService {
    //注入dao
    @Autowired
    private BookDao bookDao;

    //添加的方法
    public void addUser(Book book){
        bookDao.add(book);
    }

    public void update(Book book){
        bookDao.update(book);
    }

    public void delete(String id){
        bookDao.delete(id);
    }

    //查询表记录数
    public int findCount(){
        return bookDao.selectCount();
    }

    //查询一条语句
    public Book findOne(String id){
        return bookDao.findBookInfo(id);
    }

    //查询一条语句
    public List<Book> findAll(){
        return bookDao.findAllBookInfo();
    }

    //批量添加
    public void batchAdd(List<Object[]> batchArgs){
        bookDao.batchAddBook(batchArgs);
    }

    //批量修改
    public void batchUpdate(List<Object[]> batchArgs){
        bookDao.batchUpdateBook(batchArgs);
    }

    //批量删除
    public void batchDelete(List<Object[]> batchArgs){
        bookDao.batchDeleteBook(batchArgs);
    }
}
