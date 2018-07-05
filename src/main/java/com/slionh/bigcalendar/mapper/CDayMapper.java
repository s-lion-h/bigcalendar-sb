package com.slionh.bigcalendar.mapper;

import com.slionh.bigcalendar.model.Event;

import java.util.List;

/*
 * Create by s lion h on 2018/4/18
 */

public interface CDayMapper {
    List<Event> getAllEvent();
    int addEvent(Event event);
    Event getAllEvent2();
    List<Event> getEventByDate(String date);
}
