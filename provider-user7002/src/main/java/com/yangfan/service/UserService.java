package com.yangfan.service;

import com.yangfan.bean.User;
import com.yangfan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getUserAll(){
        return userMapper.iGetUser();
    }
}
