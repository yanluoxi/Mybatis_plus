package com.dxc.mybaitsplus.servcie.Impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dxc.mybaitsplus.mapper.UserMapper;
import com.dxc.mybaitsplus.pojo.User;
import com.dxc.mybaitsplus.servcie.UserService;
import org.springframework.stereotype.Service;

@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
