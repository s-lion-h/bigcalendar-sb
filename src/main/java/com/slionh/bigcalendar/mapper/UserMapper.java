package com.slionh.bigcalendar.mapper;

import com.slionh.bigcalendar.model.User;

/*
 * Create by s lion h on 2018/4/19
 */
public interface UserMapper {
    int userRegist(User user);
    User userLogin(User user);
}
