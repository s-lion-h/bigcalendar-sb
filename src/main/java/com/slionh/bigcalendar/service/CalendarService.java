package com.slionh.bigcalendar.service;

import com.slionh.bigcalendar.model.MyCalendar;

/*
 * Create by s lion h on 2018/4/18
 */
public interface CalendarService {
    @Deprecated
    MyCalendar getCalendar();
    MyCalendar getNowCalendar();
    MyCalendar getMonthCalendar(Integer month);
}
