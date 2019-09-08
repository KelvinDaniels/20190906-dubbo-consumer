package com.aaa.dubbo.controller;

import com.aaa.dubbo.model.Book;
import com.aaa.dubbo.service.IBookService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BookController
 * @Author 王宇
 * @Date 2019/9/6 19:53
 * @Version 1.0
 */
@Controller
public class BookController {
    /**
     * roundribbon:轮询
     * random:随机
     * leastActive:最小活跃数访问：谁被请求数最小访问谁
     */
    @Reference(loadbalance = "random")
    private IBookService bookService;

    /**
     * 跳转到图书详情页
     * @return
     */
    @RequestMapping("/turnAllPage")
    private String turnAllPage() {
        return "book_all";
    }

    /**
     * 查询数据并返回详情页
     * @return
     */
    @RequestMapping("/selectAllBook")
    @ResponseBody
    private Map<String, Object> selectAllBook() {
        return bookService.selectAllBook();
    }

    @RequestMapping("/deleteBook")
    @ResponseBody
    private Map<String, Object> deleteBook(Integer id) {
        return bookService.deleteBook(id);
    }

    /**
     * 跳转到图书添加页
     * @return
     */
    @RequestMapping("/turnInsertPage")
    private String turnInsertPage() {
        return "book_insert";
    }

    /**
     * 根据传入参数是否有id判断添加还是修改
     * @param book
     * @return
     */
    @RequestMapping("/insertOrUpdateBook")
    private String insertOrUpdateBook(Book book) {
        Map<String, Object> resultMap = bookService.insertOrUpdateBook(book);
        if (200 == (Integer) resultMap.get("code")) {
            return "book_all";
        }
        return "404";
    }

    @RequestMapping("/selectBookById")
    @ResponseBody
    private Map<String, Object> selectBookById(Integer id) {
        Map<String, Object> resultMap = bookService.selectByPrimaryKey(id);
        return resultMap;
    }

}
