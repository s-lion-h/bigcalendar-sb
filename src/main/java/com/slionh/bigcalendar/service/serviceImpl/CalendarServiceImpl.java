package com.slionh.bigcalendar.service.serviceImpl;

import com.slionh.bigcalendar.model.CDay;
import com.slionh.bigcalendar.model.Event;
import com.slionh.bigcalendar.model.MyCalendar;
import com.slionh.bigcalendar.service.CDayService;
import com.slionh.bigcalendar.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
 * Create by s lion h on 2018/4/18
 */
@Service
public class CalendarServiceImpl implements CalendarService {
    @Autowired
    private CDayService cDayService;

    @Override
    public MyCalendar getCalendar() {
        MyCalendar myCalendar=new MyCalendar();
        Date date=new Date();

//        mycalendar设置年月日
        myCalendar.setYear(date.getYear()+1900);
        myCalendar.setMonth(date.getMonth()+1);
        myCalendar.setToday(date.getDate());

//        使用calendar类获取当前年月的天数
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Integer days=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_WEEK));
        Integer dayOfWeek=calendar.DAY_OF_WEEK;
        myCalendar.setDayOfWeek(dayOfWeek);

//        按当月天数封装cDayList
        List<CDay> cDayList=new ArrayList<CDay>();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        for(int i=1;i<=days;i++){
            date.setDate(i);
            List<Event> events= cDayService.getEventByDate(df.format(date));
            CDay cDay=new CDay();
            cDay.setDay(i);
            cDay.setEvent(events);
            cDayList.add(cDay);
        }

//        myCalendar当前时间calendar生产
        myCalendar.setcDays(cDayList);

        return myCalendar;
    }
}
