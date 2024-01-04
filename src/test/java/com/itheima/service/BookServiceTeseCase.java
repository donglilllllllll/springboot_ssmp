package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/**
 *
 * @author kaixiang
 * date:2024/1/4 10:48
 */
@SpringBootTest
public class BookServiceTeseCase {
    @Autowired
    private  IBookService bookService;

    @Test
    void testGetByid(){
        System.out.println(bookService.getById(4));

    }
    @Test
    void testsave(){
        Book book = new Book();
        book.setName("小明");
        book.setType("小明");
        book.setDescription("小明");

        System.out.println(bookService.save(book));

    }

    @Test
    void testupdate(){
        Book book = new Book();
        book.setId(10);
        book.setName("小明");
        book.setType("小明");
        book.setDescription("小明");
        System.out.println(bookService.updateById(book));

    }
    @Test
    void testdelete(){

        System.out.println(bookService.removeById(19));

    }
    @Test
    void testgetAll(){

        System.out.println(bookService.list());

    }

    @Test
    void testgetPage(){
        IPage<Book> page = new Page<Book>(1,10);
        System.out.println(bookService.page(page));

    }












}
