package com.slionh.bigcalendar.controller;

import com.slionh.bigcalendar.model.Event;
import com.slionh.bigcalendar.model.User;
import com.slionh.bigcalendar.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/*
 * Create by s lion h on 2018/4/24
 */
@Controller
public class EventController {
    @Autowired
    private EventService eventService;

    @RequestMapping("/addEvent")
    public String addEvent(Event event, HttpServletRequest request){
        User user =(User)request.getSession().getAttribute("user");
        event.setUid(user.getId());
        eventService.addEvent(event);
        return "redirect:/";
    }
}
