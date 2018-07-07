package com.slionh.bigcalendar.model;

import java.util.List;

/*
 * Create by s lion h on 2018/4/18
 */
public class MyCalendar {
    private Integer year;
    private Integer month;
    private Integer today;
    private Integer dayOfWeek;
    private Integer days;

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    private List<CDay> cDays;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getToday() {
        return today;
    }

    public void setToday(Integer today) {
        this.today = today;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<CDay> getcDays() {
        return cDays;
    }

    public void setcDays(List<CDay> cDays) {
        this.cDays = cDays;
    }

    @Override
    public String toString() {
        return "MyCalendar{" +
                "year=" + year +
                ", month=" + month +
                ", today=" + today +
                ", dayOfWeek=" + dayOfWeek +
                ", days=" + days +
                ", cDays=" + cDays +
                '}';
    }
}
