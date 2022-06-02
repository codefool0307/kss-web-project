package com.kuangstudy.service.blogcategory;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kuangstudy.entity.BlogCategory;

import java.util.List;

public interface IBlogCategoryService extends IService<BlogCategory> {

    /**
     * 查询首页分类
     * @return
     */
    List<BlogCategory> findBlogCategies();
}
