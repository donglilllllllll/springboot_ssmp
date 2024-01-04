package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mapper.bookMapper;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 凯祥
 */
@Service
public class IBookServiceImpl extends ServiceImpl<bookMapper, Book> implements IBookService {
    @Autowired
    private bookMapper bookmapper;

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        queryWrapper.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        queryWrapper.like(Strings.isNotEmpty(book.getType()), Book::getDescription, book.getDescription());
        IPage<Book> page = new Page<>(currentPage, pageSize);
        return bookmapper.selectPage(page, queryWrapper);
    }
}
