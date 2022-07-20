package com.JdbcTemplate.service;

import com.JdbcTemplate.dao.BookDao;
import com.JdbcTemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void update(String id){
        bookDao.delete(id);
    }
}
