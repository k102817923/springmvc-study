package com.springmvc.service;

import com.springmvc.dao.BookMapper;
import com.springmvc.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService {
    // 调用 Dao 层的操作，设置一个 set 接口，方便 Spring 管理
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int insert(Books book) {
        return bookMapper.insert(book);
    }

    @Override
    public int deleteById(int id) {
        return bookMapper.deleteById(id);
    }

    @Override
    public int update(Books book) {
        return bookMapper.update(book);
    }

    @Override
    public Books queryById(int id) {
        return bookMapper.queryById(id);
    }

    @Override
    public List<Books> queryAll() {
        return bookMapper.queryAll();
    }
}
