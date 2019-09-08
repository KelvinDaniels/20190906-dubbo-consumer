package com.aaa.dubbo.service;

import com.aaa.dubbo.model.Book;

import java.util.List;
import java.util.Map;

public interface IBookService {
    /**
     * 查询所有图书
     * @return
     */
    Map<String, Object> selectAllBook();

    /**
     * 根据id删除图书
     * @param id
     * @return
     */
    Map<String, Object> deleteBook(Integer id);
    /**
     * 根据传参是否包含id判断插入还是更新
     * @param book
     * @return
     */
    Map<String, Object> insertOrUpdateBook(Book book);
    /**
     * 根据id查询图书信息
     *
     * @param id
     * @return
     */
    Map<String, Object> selectByPrimaryKey(Integer id);
}
