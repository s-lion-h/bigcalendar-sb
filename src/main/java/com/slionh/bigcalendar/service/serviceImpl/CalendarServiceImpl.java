package com.slionh.bigcalendar.service.serviceImpl;

import com.slionh.bigcalendar.model.CDay;
import com.slionh.bigcalendar.model.Event;
import com.slionh.bigcalendar.model.MyCalendar;
import com.slionh.bigcalendar.service.CDayService;
import com.slionh.bigcalendar.service.CalendarService;
import com.slionh.bigcalendar.service.EventService;
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
    @Autowired
    private EventService eventService;

    @Deprecated
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

    @Override
    public MyCalendar getNowCalendar() {
        Date date=new Date();
        return getMonthCalendar(date.getMonth()+1);
    }

    @Override
    public MyCalendar getMonthCalendar(Integer month) {
//        System.out.println("---------------------------");
        MyCalendar myCalendar=new MyCalendar();
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();

        calendar.set(date.getYear()+1900,month-1,1);

        myCalendar.setYear(calendar.get(Calendar.YEAR));
        myCalendar.setMonth(month);
        myCalendar.setToday(date.getDate());
        int dayOfWeek=calendar.get(Calendar.DAY_OF_WEEK)-1;
        if (dayOfWeek==0)
            dayOfWeek=7;
        myCalendar.setDayOfWeek(dayOfWeek);

        Integer days=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//        System.out.println("有"+days+"天");
        myCalendar.setDays(days);

//        构造好的特定时间
        Date temp=calendar.getTime();
        List<CDay> cDayList=new ArrayList<CDay>();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dfByEvent=new SimpleDateFormat("yyyy-MM");

        List<Event> events=eventService.listMonthList(dfByEvent.format(temp));
        for (Event event:events){
            System.out.println(event.toString()  );
        }

        for(int i=1;i<=days;i++){
            temp.setDate(i);
//            List<Event> events= cDayService.getEventByDate(df.format(temp));
            CDay cDay=new CDay();
            cDay.setDay(i);
            cDay.setDate8(df.format(temp));
            List<Event> events1=new ArrayList<Event>();
            for (Event event:events){
                if (event.getDate().equals(df.format(temp))){
                    events1.add(event);
                }
            }
            cDay.setEvent(events1);
//            cDay.setEvent(events);
            cDayList.add(cDay);
        }

        myCalendar.setcDays(cDayList);
//        System.out.println(myCalendar.toString());

        return myCalendar;
    }
}
