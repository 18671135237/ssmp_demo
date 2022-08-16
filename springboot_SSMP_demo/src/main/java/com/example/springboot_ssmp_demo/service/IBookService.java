package com.example.springboot_ssmp_demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot_ssmp_demo.po.Book;

public interface IBookService extends IService<Book> {

    public IPage<Book> getPage(Integer currentPage,Integer pageSize);

}
