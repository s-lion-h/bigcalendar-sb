package com.slionh.bigcalendar.mapper;

import com.slionh.bigcalendar.model.Event;

import java.util.List;

/*
 * Create by s lion h on 2018/4/24
 */
public interface EventMapper {
    int addEvent(Event event);
    int delEvent(Integer id);
    Event findEvent(String event);
    Event changeEvent(Event event);
    List<Event> listMonthList(String monthAndYear);
}