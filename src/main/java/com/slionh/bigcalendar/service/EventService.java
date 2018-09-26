package com.slionh.bigcalendar.service;

import com.slionh.bigcalendar.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Create by s lion h on 2018/4/24
 */
@Service
public interface EventService {
    int addEvent(Event event);
    List<Event> listMonthList(String monthAndYear);
}
