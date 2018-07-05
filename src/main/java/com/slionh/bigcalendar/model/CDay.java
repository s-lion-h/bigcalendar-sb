package com.slionh.bigcalendar.model;

import java.util.List;

/*
 * Create by s lion h on 2018/4/18
 */
public class CDay {
    private Integer day;
    private List<Event> event;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }
}
