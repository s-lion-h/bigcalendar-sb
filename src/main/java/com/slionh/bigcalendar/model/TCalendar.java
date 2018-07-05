package com.slionh.bigcalendar.model;

import java.util.Date;

/*
 * Create by s lion h on 2018/4/17
 */
public class TCalendar {
    private Date date;
    private String month;
    private String year;
    private String days;
    private String startWeekDay;
    private String date8;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getStartWeekDay() {
        return startWeekDay;
    }

    public void setStartWeekDay(String startWeekDay) {
        this.startWeekDay = startWeekDay;
    }

    public String getDate8() {
        return date8;
    }

    public void setDate8(String date8) {
        this.date8 = date8;
    }
}
