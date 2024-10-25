package com.springmvc.service;

import com.springmvc.pojo.Books;

import java.util.List;

// 需要去实现，调用 Dao 层
public interface BookService {
    // 新增 Book
    public int insert(Books book);
    // 根据 ID 删除 Book
    public int deleteById(int id);
    // 更新 Book
    public int update(Books book);
    // 根据 ID 查询 Book
    public Books queryById(int id);
    // 查询 Book
    public List<Books> queryAll();
}
