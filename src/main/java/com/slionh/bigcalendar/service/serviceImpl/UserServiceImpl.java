package com.slionh.bigcalendar.service.serviceImpl;

import com.slionh.bigcalendar.mapper.UserMapper;
import com.slionh.bigcalendar.model.User;
import com.slionh.bigcalendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Create by s lion h on 2018/4/18
 */
@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int userRegist(User user) {
        user.setLevel(1);
        System.out.println(user.toString());
        return userMapper.userRegist(user);
    }

    @Override
    public User userLogin(User user) {
        User loginUser=userMapper.userLogin(user);
        System.out.println(loginUser.toString());
        return loginUser;
    }

}
