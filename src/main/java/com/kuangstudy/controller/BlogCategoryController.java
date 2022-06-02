package com.kuangstudy.controller;

import com.kuangstudy.entity.BlogCategory;
import com.kuangstudy.service.blogcategory.IBlogCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
//如果使用controller他必须要返回一个页面，如果用controller注解，那么下面必须加入responsebody
public class BlogCategoryController {

    @Autowired
    private IBlogCategoryService blogCategoryService;

    /**
     * 加载分类数据
     *
     * @return
     */
    @GetMapping("/api/blogcategory/load")
    //@ResponseBody
    public List<BlogCategory> findCategories() {
        return blogCategoryService.findBlogCategies();
    }
}
