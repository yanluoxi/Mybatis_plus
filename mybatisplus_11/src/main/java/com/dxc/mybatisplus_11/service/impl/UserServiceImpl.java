package com.dxc.mybatisplus_11.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dxc.mybatisplus_11.mapper.UserMapper;
import com.dxc.mybatisplus_11.pojo.User;
import com.dxc.mybatisplus_11.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
