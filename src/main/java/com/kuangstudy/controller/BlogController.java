package com.kuangstudy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kuangstudy.entity.Blog;
import com.kuangstudy.entity.BlogCategory;
import com.kuangstudy.service.blog.IBlogService;
import com.kuangstudy.service.blogcategory.IBlogCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
//异步里面跳页面是无法实现的
@Slf4j
public class BlogController {

    @Autowired
    private IBlogService blogService;


    /*@GetMapping("/api/blog/load")
    //@ResponseBody
    public List<Blog> findBlog() {
        return blogService.list();
    }*/

    /*@GetMapping("/api/blog/load")
    public List<Blog> findBlogCha(){
        LambdaQueryWrapper<Blog> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //查询 status= 1 发布并且 isdelete=0未删除， 根据创建时间排序 desc
        lambdaQueryWrapper
                .eq(Blog::getStatus, 1)
                .eq(Blog::getIsDelete, 0)
                .orderByDesc(Blog::getCreateTime);
        return blogService.list(lambdaQueryWrapper);
    }*/

    //数据过多，那么就要分页
    //mybatis=plus一定要设置拦截器
    @GetMapping("/api/blog/load")
    public Page<Blog> findBlog(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
                                @RequestParam(required = false, defaultValue = "4") Integer pageSize,
                                @RequestParam(required = false, defaultValue = "0") Integer cid) {
        // 1:设置分页起始和每页显示多少条
        Page page = new Page<>(pageNo, pageSize);
        // 2:设置条件
        LambdaQueryWrapper<Blog> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 3：查询 status= 1 发布并且 isdelete=0未删除， 根据创建时间排序 desc
        lambdaQueryWrapper
                // 如果用户不传递cid或者传递的是0代表查询的全部
                .eq(cid != null && !cid.equals(0), Blog::getCategoryId, cid)
                .eq(Blog::getStatus, 1)
                .eq(Blog::getIsDelete, 0)
                .orderByDesc(Blog::getCreateTime);
        // 4: 执行分页
        Page blogPage = blogService.page(page, lambdaQueryWrapper);
        // 5: 返回分页
        return blogPage;
    }
}
