package com.example.qqbot.Service.impl;


import com.example.qqbot.Events.Entity.MessageEventParam;
import com.example.qqbot.Service.InterFace.CheerUpService;
import com.example.qqbot.Service.InterFace.CountDownService;
import com.example.qqbot.Service.InterFace.GetHXJBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;


@Service
public class TimerServiceImpl {
    @Autowired
    private CheerUpService cheerUpService;
    @Autowired
    private CountDownService countDownService;
    @Autowired
    private GetHXJBlogService getHXJBlogService;
    public void Cheer(){
        cheerUpService.CheerUp();
    }

    public void Count(){
        countDownService.Countdown();
    }

//    public void HXJ(){
//        LocalDateTime localDateTime =LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
//        if(localDateTime.getHour()==0 || localDateTime.getHour()==6 || localDateTime.getHour()==12 || localDateTime.getHour()==18)  getHXJBlogService.getHXJBlog();
//    }




}
