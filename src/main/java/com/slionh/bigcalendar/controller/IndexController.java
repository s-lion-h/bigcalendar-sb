package com.slionh.bigcalendar.controller;

import com.slionh.bigcalendar.model.MyCalendar;
import com.slionh.bigcalendar.service.CDayService;
import com.slionh.bigcalendar.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * Create by s lion h on 2018/4/17
 */
@Controller
public class IndexController {
    @Autowired
    private CDayService cDayService;
    @Autowired
    private CalendarService calendarService;
    @RequestMapping("/")
    public String toIndex()
    {
        return "index";
    }
    @RequestMapping("/nav")
    public String toNav(){
        return "nav";
    }
    @RequestMapping("/calendar")
    @ResponseBody
    public MyCalendar getCalendar(){
        MyCalendar myCalendar= calendarService.getCalendar();
        System.out.println(myCalendar.toString());
        return myCalendar;
    }

    @RequestMapping("/regist")
    public String toRegist(){
        return "regist";
    }

}
