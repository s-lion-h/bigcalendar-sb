package com.slionh.bigcalendar.controller;

import com.slionh.bigcalendar.model.MyCalendar;
import com.slionh.bigcalendar.service.CDayService;
import com.slionh.bigcalendar.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
//    @RequestMapping("/nav")
//    public String toNav(){
//        return "nav";
//    }

    @RequestMapping("/getCalendar")
    public ModelAndView getTodayCalendarPage(ModelAndView modelAndView,Integer month){
        if (month==null){
            MyCalendar myCalendar= calendarService.getCalendar();
            modelAndView.addObject("calendar",myCalendar);
        }else if (1<=month&&month<=12){
            MyCalendar myCalendar= calendarService.getMonthCalendar(month);
            modelAndView.addObject("calendar",myCalendar);
        }else{
            modelAndView.addObject("errorMsg","老哥放弃注入吧，进不来的");
            modelAndView.setViewName("error");
            return modelAndView;
        }
        modelAndView.setViewName("calendarTable");
        return modelAndView;
    }

    @RequestMapping("/regist")
    public String toRegist(){
        return "regist";
    }

//    返回当天的json-mycalendar
    @RequestMapping("/getJsonCalendar")
    @ResponseBody
    public MyCalendar getCalendar(){
        MyCalendar myCalendar= calendarService.getCalendar();
        System.out.println(myCalendar.toString());
        return myCalendar;
    }

//    返回某月的json-mycalendar
    @RequestMapping("/getMonthJsonCalendar")
    @ResponseBody
    public MyCalendar getMonthCalendar(Integer month){
        MyCalendar myCalendar= calendarService.getMonthCalendar(month);
        System.out.println(myCalendar.toString());
        return myCalendar;
    }
}
