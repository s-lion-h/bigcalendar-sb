package com.slionh.bigcalendar.model;

import java.util.List;

/*
 * Create by s lion h on 2018/4/18
 */
public class CDay {
    private Integer day;
    private String date8;
    private List<Event> event;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getDate8() {
        return date8;
    }

    public void setDate8(String date8) {
        this.date8 = date8;
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "CDay{" +
                "day=" + day +
                ", date8='" + date8 + '\'' +
                ", event=" + event +
                '}';
    }
}
