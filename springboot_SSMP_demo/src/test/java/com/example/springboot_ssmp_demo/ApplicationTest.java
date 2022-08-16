package com.example.springboot_ssmp_demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_ssmp_demo.dao.IBookDao;
import com.example.springboot_ssmp_demo.po.Book;
import com.example.springboot_ssmp_demo.service.IBookService;
import okhttp3.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
class ApplicationTest {

    @Autowired
    private IBookDao bookDao;
    @Autowired
    private IBookService bookService;

    @Test
    void selectAll() {
        // 查询全部
        System.out.println(bookDao.selectList(null));
        System.out.println(bookService.list());
    }

    @Test
    void getById(){
        // 根据ID查询
        System.out.println(bookDao.selectById(1));
        System.out.println(bookService.getById(1));
    }

    @Test
    void getByCondition(){
        // 按条件查询
        QueryWrapper<Book> qw = new QueryWrapper<>();

        // 查询 price >= 60 的记录 【 ge是 >= , gt是 > , le是 <= , lt是 <】
        qw.ge("price",60);

        // 查询 bookName 等于 “框架” 的记录 【 eq是等于 , ne 是不等于 】
        qw.eq("book_name","框架");

        // 查询 price 范围在 80 - 100 之间的记录 【 between 范围查询 】
        qw.between("price",80,100);

        // 查询 bookName 包含 “框架” 的记录 【 like 模糊查询 】
        qw.like("book_name","框架");

        // 查询指定的列
        qw.select("price");

        System.out.println(bookDao.selectList(qw));
    }

    @Test
    void insert(){
        // 插入数据，返回受影响行数
        Book book = new Book();
        book.setBookName("SpringMVC框架");
        book.setPrice(89);
        System.out.println(bookDao.insert(book) > 0);
    }

    @Test
    void delete(){
        // 根据ID删除
        System.out.println(bookDao.deleteById(2) > 0);
    }

    @Test
    void getPage(){
        // 分页【 第四页，每页3条数据 】
        IPage page = new Page(4,3);
//        IPage iPage = bookDao.selectPage(page, null);
        IPage iPage = bookService.page(page);
        System.out.println("分页数据：" + iPage.getRecords());
        System.out.println("当前页码：" + iPage.getCurrent());
        System.out.println("每页数据量：" + iPage.getSize());
        System.out.println("最大页码值：" + iPage.getPages());
        System.out.println("数据总量：" + iPage.getTotal());
    }


    @Test
    void test() {
        String url = "https://openapi.italent.cn/RecruitV6/api/v1/Applicant/GetResume?applicantId=4b482cac-b3c2-4c64-8203-9efca1fbcf6f";
        String token = "X4eTEiMr-UHQtfzxOvdy6Z4B479EwHvZ9-X8_Arwn1J9GzlyOICWKEicXuP9KJOp9hvt3X3Z0";

    }





}
