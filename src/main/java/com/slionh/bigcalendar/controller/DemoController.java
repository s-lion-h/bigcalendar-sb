package com.slionh.bigcalendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Create by s lion h on 2018/7/14
 */
@Controller
public class DemoController {
    @RequestMapping("/vue")
    public String vue(){
        return "../demo/vueTest";
    }
    @RequestMapping("/indexVue")
    public String indexVue(){
        return "indexVue";
    }

    @RequestMapping("demo")
    public String demo(){
        return "demo";
    }
}
