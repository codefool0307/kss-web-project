package com.kuangstudy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuangstudy.entity.Blog;
import com.kuangstudy.entity.BlogCategory;
import com.kuangstudy.service.blog.IBlogService;
import com.kuangstudy.service.blogcategory.IBlogCategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: 首页controller
 * Author: yykk Administrator
 * Version: 1.0
 * Create Date Time: 2021/11/9 21:57.
 * Update Date Time:
 *
 * @see
 */
@Controller
@Log4j2
public class IndexController {

    @Autowired
    private IBlogCategoryService blogCategoryService;

    @Autowired
    private IBlogService blogService;

    /**
     * Description: 第一版首页
     * @throws Exception
     */
    @GetMapping("/first")
    public String firstindex(){
        return "index";
    }

    /**
     * Description: 第1版freemark首页
     * @throws Exception
     */
    @GetMapping("/freemark1")
    public String freemark1(ModelMap modelMap){
        List<BlogCategory> blogCategories = blogCategoryService.list();
        modelMap.addAttribute("blogCategories",blogCategories);//key必须与index标签保持一致
        return "index";
    }

    /**
     * Description: 第2版freemark首页
     * @throws Exception
     */
    @GetMapping("/freemark2")
    public ModelAndView freemark2(){
        ModelAndView modelAndView = new ModelAndView();
        List<BlogCategory> blogCategories = blogCategoryService.list();
        modelAndView.addObject("blogCategories",blogCategories);//key必须与index标签保持一致
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * Description: 第3版freemark首页
     * @throws Exception
     */
    @GetMapping( "/freemark3")
    public ModelAndView freemark3() {
        ModelAndView modelAndView = new ModelAndView();
        // 5: 把查询分类放入到数据模型中
        modelAndView.addObject("blogCategories", blogCategoryService.findBlogCategies());
        //对于博客内容的话，采用freemark，就得一条条执行，不能跳跃了
        List<Blog> blog = blogService.list();
        modelAndView.addObject("blog",blog);//key必须与index标签保持一致
        // 6: 跳转视图模板
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * Description: 异步方式首页
     * @throws Exception
     */
    @GetMapping(value = {"/","/newsindex"})
    public ModelAndView newindex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newsindex");
        return modelAndView;
    }
}
