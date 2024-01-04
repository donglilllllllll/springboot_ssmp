package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.result.Result;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
/**
 *
 * @author kaixiang
 * date:2024/1/4 10:47
 */



@RestController
@RequestMapping("/book")
public class BookController2 {
    @Autowired
    private IBookService iBookService;

    @GetMapping
    public Result getAll() {

        return new Result(true, iBookService.list());

    }

    @PostMapping
    public Result save(@RequestBody Book book) throws IOException {

        if (book.getName().equals("123")) throw new IOException();
        Boolean flag = iBookService.save(book);
        return new Result(flag,flag ? "添加成功" : "添加失败");
    }

    @PutMapping
    public Result update(@RequestBody Book book) {

        Boolean flag = iBookService.updateById(book);
        return new Result(flag,flag ? "修改成功" : "修改失败");
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {

        Boolean flag = iBookService.removeById(id);
        return new Result(flag,flag ? "删除成功" : "数据同步失败，自动刷新");
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
       Book book1 = iBookService.getById(id);
       Boolean flag;
       if (book1 != null){
           flag = true;
       }else {
           flag = false;
       }
       return new Result(flag,book1,flag ?"查询成功" :"数据同步失败，自动刷新" );

    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book) {

        IPage<Book> page = iBookService.getPage(currentPage, pageSize,book);
        if(currentPage > page.getPages()) {
            page = iBookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new Result(true, page, "查询成功");
    }

}
