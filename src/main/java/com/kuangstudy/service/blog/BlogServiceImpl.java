package com.kuangstudy.service.blog;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuangstudy.entity.Blog;
import com.kuangstudy.entity.BlogCategory;
import com.kuangstudy.mapper.BlogCategoryMapper;
import com.kuangstudy.mapper.BlogMapper;
import com.kuangstudy.service.blogcategory.IBlogCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
