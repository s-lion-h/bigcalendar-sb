package com.slionh.bigcalendar.service;

import com.slionh.bigcalendar.model.Event;
import org.springframework.stereotype.Service;

/*
 * Create by s lion h on 2018/4/24
 */
@Service
public interface EventService {
    int addEvent(Event event);
}
