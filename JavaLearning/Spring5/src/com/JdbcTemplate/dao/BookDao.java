package com.JdbcTemplate.dao;

import com.JdbcTemplate.entity.Book;

public interface BookDao {
    void add(Book book);

    void delete(String id);

    void update(Book book);
}
