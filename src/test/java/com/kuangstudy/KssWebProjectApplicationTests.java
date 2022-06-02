package com.kuangstudy;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kuangstudy.entity.User;
import com.kuangstudy.mapper.UserMapper;
import com.kuangstudy.service.user.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class KssWebProjectApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;

    @Test
    public void testSelect() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setId(2);
        user.setNickname("rt");
        user.setPassword("3423423423");
        user.setSign("我是一个小可爱");
        boolean update = userService.saveOrUpdate(user);
    }

    //注意，分也要配置一个拦截器，在柱函数配置
    @Test
    public void testpage(){
        // 1、设置分页
        Page<User> page = new Page<>(1,2);
        // 2：设置条件
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 3：查询分页返回
        Page<User> userPage = userService.page(page, lambdaQueryWrapper);
        // 这个userService.page 第一步：发起一个select * from user limit 1,2 //从第一条开始查询，取2条数据；；；；1，2是从page来的
        // 这个userService.page 第二步：发起一个 select count(1) from (select * from user)
        System.out.println(userPage.getTotal());
        System.out.println(userPage.getPages());
        List<User> records = userPage.getRecords();
        records.forEach(System.out::println);
    }














}
