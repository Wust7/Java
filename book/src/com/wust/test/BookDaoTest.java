package com.wust.test;

import com.wust.dao.BookDao;
import com.wust.dao.impl.BookDaoImpl;
import com.wust.pojo.Book;
import com.wust.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        System.out.println(bookDao.addBook(new Book(null, "XCG", "123123", new BigDecimal(9999), 1000000, 0, null)));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        System.out.println(bookDao.updateBook(new Book(21, "XCG1", "1231231", new BigDecimal(99991), 1000000, 0, null)));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        System.out.println(bookDao.queryBooks());
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Book book : bookDao.queryForPageItems(8, Page.PAGE_SIZE)) {
            System.out.println(book);
        }
    }

}