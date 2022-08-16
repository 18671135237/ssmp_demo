package com.example.springboot_ssmp_demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springboot_ssmp_demo.controller.utils.ReturnModel;
import com.example.springboot_ssmp_demo.po.Book;
import com.example.springboot_ssmp_demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/*
    http://127.0.0.1:9000/books         GET     查询全部
    http://127.0.0.1:9000/books/4       GET     根据ID查询     【参数：id】
    http://127.0.0.1:9000/books         POST    新增          【参数：{"bookName":"测试","price":"100"}】
    http://127.0.0.1:9000/books         PUT     修改          【参数：{"id":"13","bookName":"测试名称","price":"20"}】
    http://127.0.0.1:9000/books/14      DELETE  根据ID删除     【参数：id】
    http://127.0.0.1:9000/books/1/5     GET     分页查询       【参数：第几页，显示数据量】
*/

@RestController
@RequestMapping("/books")
public class BookRestController {
    
    @Autowired()
    private IBookService bookService;

    @GetMapping
    public ReturnModel getAll() throws IOException {
        // 查询全部
        return new ReturnModel(true,bookService.list());
    }
    @PostMapping
    public ReturnModel save(@RequestBody Book book){
        // 新增数据
        boolean flag = bookService.save(book);
        return new ReturnModel(flag,flag ? "添加成功^_^":"添加失败-_-");
    }
    @PutMapping
    public ReturnModel update(@RequestBody Book book){
        // 根据ID修改
        boolean flag = bookService.updateById(book);
        return new ReturnModel(flag,flag ? "修改成功^_^":"修改失败-_-");
    }
    @DeleteMapping("{id}")
    public ReturnModel delete(@PathVariable Integer id){
        // 根据ID删除
        boolean flag = bookService.removeById(id);
        return new ReturnModel(flag,flag ? "删除成功^_^":"删除失败-_-");
    }
    @GetMapping("{id}")
    public ReturnModel getById(@PathVariable Integer id){
        // 根据ID查询
        return new ReturnModel(true,bookService.getById(id),"查询成功");
    }
    @GetMapping("{currentPage}/{pageSize}")
    public ReturnModel getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        // 分页查询【第currentPage页，显示pageSize条数据】
        IPage<Book> page = bookService.getPage(currentPage, pageSize);

        // 若当前页码值大于总页码值，则直接返回第一页数据【解决删除BUG】
        if (currentPage > page.getPages()){
            page = bookService.getPage(1,pageSize);
        }
        return new ReturnModel(true,page);
    }

}
