package com.dxc.mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dxc.mybatisx.pojo.User;
import com.dxc.mybatisx.service.UserService;
import com.dxc.mybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author yanji
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2023-05-25 15:44:21
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




