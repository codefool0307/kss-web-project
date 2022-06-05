package com.kuangstudy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kuangstudy.entity.Blog;
import com.kuangstudy.service.blog.IBlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class BlogDetailController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/detail/{blogId}")
    public ModelAndView blogdetail(@PathVariable("blogId")Integer blogId){
        // 1； 定义数据模型
        ModelAndView modelAndView = new ModelAndView();
        // 2: 根据id查询
        Blog blog = blogService.getById(blogId);
        // 3: 把数据放入数据模型中
        modelAndView.addObject("blog",blog);
        // 4: 把视图放入进去 ,注意：这里blog前面千万不要加/否则找不到页面
        modelAndView.setViewName("/blog/detail");
        return modelAndView;
    }






}
