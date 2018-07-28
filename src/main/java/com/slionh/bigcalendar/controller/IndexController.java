package com.slionh.bigcalendar.controller;

import com.slionh.bigcalendar.model.MyCalendar;
import com.slionh.bigcalendar.model.User;
import com.slionh.bigcalendar.service.CDayService;
import com.slionh.bigcalendar.service.CalendarService;
import com.slionh.githubApi.parse.GitUtil;
import com.slionh.githubApi.po.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/*
 * Create by s lion h on 2018/4/17
 */
@Controller
public class IndexController {
    private static final String TOKEN="6a0abf2f1b26f6d6c4161b9d0a8802c351179c46";

    @Autowired
    private CDayService cDayService;
    @Autowired
    private CalendarService calendarService;
    @RequestMapping("/")
    public String toIndex(HttpServletRequest request)
    {
        return "indexVue";
    }
//    @RequestMapping("/nav")
//    public String toNav(){
//        return "nav";
//    }

    @RequestMapping("/getCalendar")
    public ModelAndView getTodayCalendarPage(ModelAndView modelAndView,Integer month,HttpServletRequest request,HttpServletResponse response)
            throws ExecutionException, InterruptedException {
        if (month==null){
            MyCalendar myCalendar= calendarService.getCalendar();
            modelAndView.addObject("calendar",myCalendar);
        }else if (1<=month&&month<=12){
            MyCalendar myCalendar= calendarService.getMonthCalendar(month);
            modelAndView.addObject("calendar",myCalendar);
        }else{
            modelAndView.addObject("errorMsg","老哥放弃注入吧，进不来的");
            modelAndView.setViewName("error");
            return modelAndView;
        }

        User user= (User) request.getSession().getAttribute("user");
//        已绑定user可直接获取git相关列表
        if(user!=null){
            String username="echisan";
            List<Repository> repositories= null;
            try{
                repositories = GitUtil.getThreadFollowingRepo(username,TOKEN);
    //            repositories = GitUtil.getFollowingRepo(username,TOKEN);
                List<Repository> myRepositories=GitUtil.getRepositoryLists(username,TOKEN);
                modelAndView.addObject("repositories",repositories);
                modelAndView.addObject("myRepositories",myRepositories);
            }catch (Exception e){
                System.out.println("api请求次数过多或token异常");
            }
        }

        modelAndView.setViewName("calendarTable");
        return modelAndView;
    }

    @RequestMapping("/regist")
    public String toRegist(){
        return "regist";
    }

//    返回当天的json-mycalendar
    @RequestMapping("/getJsonCalendar")
    @ResponseBody
    public MyCalendar getCalendar(){
        MyCalendar myCalendar= calendarService.getNowCalendar();
        System.out.println(myCalendar.toString());
        return myCalendar;
    }

//    返回某月的json-mycalendar
    @RequestMapping("/getMonthJsonCalendar")
    @ResponseBody
    public MyCalendar getMonthCalendar(Integer month){
        MyCalendar myCalendar= calendarService.getMonthCalendar(month);
        System.out.println(myCalendar.toString());
        return myCalendar;
    }

    @RequestMapping("/getMonthJsonUser")
    @ResponseBody
    public Map getDemo(){
        Map map=new HashMap();
        User user=new User();
        user.setEmail("huyungui@11.com");
        user.setUsername("huyungui");
        map.put("user",user);
        map.put("calendar",calendarService.getMonthCalendar(7));
        return map;
    }

    @RequestMapping("/elementui")
    public String fff(){
        return "elementui";
    }

    @RequestMapping("/admin")
    public String toadmin(){
        return "admin";
    }
}
