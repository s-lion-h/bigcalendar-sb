package com.slionh.bigcalendar.controller;

import com.slionh.bigcalendar.spider.wallstreetcn.IPOData;
import com.slionh.bigcalendar.spider.wallstreetcn.IPODataUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * Create by s lion h on 2018/9/26
 */
@RestController
public class SpiderController {
    @RequestMapping("getIPOData")
    public List<IPOData> getipodata(){
        return IPODataUtil.getTimeIPO("1537372800","1537459199");
    }
}
