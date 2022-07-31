package com.JdbcTemplate.test;

import com.JdbcTemplate.entity.Book;
import com.JdbcTemplate.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestBook {
    @Test
    public void testJdbcTemplate(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("JdbcTemplate.xml");
        // bookService --> BookService
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setId("2");
        book.setUserName("3");
        book.setUserStatus("4");
//        bookService.addUser(book);
//        bookService.update(book);
//        bookService.delete("2");
//        System.out.println(bookService.findCount());
//        System.out.println(bookService.findOne("1"));
//        System.out.println(bookService.findAll());
        List<Object[]> batchArgs=new ArrayList<>();
//        Object[] o1 = {"2","33","33"};
//        Object[] o2 = {"3","44","44"};
//        Object[] o3 = {"4","55","55"};
//        Object[] o1 = {"336","33","2"};
//        Object[] o2 = {"44","446","3"};
//        Object[] o3 = {"556","55","4"};
        Object[] o1 = {"2"};
        Object[] o2 = {"3"};
        Object[] o3 = {"4"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
//        bookService.batchAdd(batchArgs);
//        bookService.batchUpdate(batchArgs);
        bookService.batchDelete(batchArgs);
    }
}
