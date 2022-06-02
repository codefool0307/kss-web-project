package com.kuangstudy.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuangstudy.entity.User;
import com.kuangstudy.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService{


}
