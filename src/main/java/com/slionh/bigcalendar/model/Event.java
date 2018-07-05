package com.slionh.bigcalendar.model;

/*
 * Create by s lion h on 2018/4/17
 */
public class Event {
    private Integer id;
    private String date;
    private String event;
    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date=" + date +
                ", event='" + event + '\'' +
                ", uid=" + uid +
                '}';
    }
}
