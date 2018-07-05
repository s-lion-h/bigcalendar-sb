package com.slionh.bigcalendar.service;

import com.slionh.bigcalendar.model.User;

/*
 * Create by s lion h on 2018/4/18
 */
public interface UserService {
    int userRegist(User user);
    User userLogin(User user);
}
