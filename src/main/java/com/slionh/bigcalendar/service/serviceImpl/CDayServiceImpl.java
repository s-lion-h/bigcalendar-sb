package com.slionh.bigcalendar.service.serviceImpl;

import com.slionh.bigcalendar.mapper.CDayMapper;
import com.slionh.bigcalendar.model.CDay;
import com.slionh.bigcalendar.model.Event;
import com.slionh.bigcalendar.service.CDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Create by s lion h on 2018/4/18
 */
@Service
public class CDayServiceImpl implements CDayService {
    @Autowired
    public CDayMapper cDayMapper;

    @Override
    public CDay getCDay(Integer day) {
        return null;
    }

    @Override
    public List<Event> getAllEvent() {
        List<Event> events=cDayMapper.getAllEvent();
        for (Event event:events){
            System.out.println(event.toString());
        }
        return null;
    }
    public Event getAllEvent2() {
        return this.cDayMapper.getAllEvent2();
    }

    @Override
    public List<Event> getEventByDate(String date) {
        return this.cDayMapper.getEventByDate(date);
    }
}
