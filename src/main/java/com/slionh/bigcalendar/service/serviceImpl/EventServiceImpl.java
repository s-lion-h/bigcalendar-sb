package com.slionh.bigcalendar.service.serviceImpl;

import com.slionh.bigcalendar.mapper.EventMapper;
import com.slionh.bigcalendar.model.Event;
import com.slionh.bigcalendar.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Create by s lion h on 2018/4/24
 */
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventMapper eventMapper;
    @Override
    public int addEvent(Event event) {
        System.out.println(event);
        return eventMapper.addEvent(event);
    }

}
