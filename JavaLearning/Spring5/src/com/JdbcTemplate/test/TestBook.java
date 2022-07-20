package com.JdbcTemplate.test;

import com.JdbcTemplate.entity.Book;
import com.JdbcTemplate.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {
    @Test
    public void testJdbcTemplate(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("JdbcTemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setId("2");
        book.setUserName("1");
        book.setUserStatus("1");
        bookService.addUser(book);

    }
}
