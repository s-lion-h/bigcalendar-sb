package com.slionh.bigcalendar.service;

import com.slionh.bigcalendar.model.CDay;
import com.slionh.bigcalendar.model.Event;

import java.util.List;

/*
 * Create by s lion h on 2018/4/18
 */
public interface CDayService {
    CDay getCDay(Integer day);
    List<Event> getAllEvent();
    Event getAllEvent2();
    List<Event> getEventByDate(String date);
}
