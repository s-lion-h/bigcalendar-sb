package com.slionh.bigcalendar.controller;

import com.slionh.bigcalendar.model.User;
import com.slionh.bigcalendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/*
 * Create by s lion h on 2018/4/18
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/UserRegist")
    public String userRegist(User user){
        System.out.println(userService.userRegist(user));
        return "redirect:/";
    }
    @RequestMapping("/UserLogin")
    public String userLogin(HttpServletRequest request, User user){
        User tryloginUser=userService.userLogin(user);
        if(tryloginUser!=null){
            request.getSession().setAttribute("user",tryloginUser);
            return "redirect:/";
        }else{
            return "error";
        }
    }
    @RequestMapping("/Logout")
    public String userLogout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }
}
