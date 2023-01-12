package com.ziv.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziv.reggie.entity.User;
import com.ziv.reggie.mapper.UserMapper;
import com.ziv.reggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author ziv
 * @version 1.0
 * @className UserServiceImpl
 * @date 2023/1/10 20:36:45
 * @since 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
