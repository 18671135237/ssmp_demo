package com.example.springboot_ssmp_demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_ssmp_demo.po.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBookDao extends BaseMapper<Book> {



}
