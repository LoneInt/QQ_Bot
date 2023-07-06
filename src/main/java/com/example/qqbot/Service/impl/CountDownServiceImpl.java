package com.example.qqbot.Service.impl;

import com.example.qqbot.API.ApiUtil.SendMessage;
import com.example.qqbot.Events.Entity.MessageEventParam;
import com.example.qqbot.Service.InterFace.CountDownService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;
import static com.example.qqbot.API.ApiUtil.SendMessage.SendMessage;



@Service
public class CountDownServiceImpl implements CountDownService {
    @Override
    public void Countdown() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Beijing"));;
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        LocalDateTime aimTime = LocalDateTime.of(2023, 6, 25, 0, 0, 0);
        long secondDiff = ChronoUnit.SECONDS.between(localDateTime, aimTime);
        StringBuilder Output = new StringBuilder();
        long hour = 0 , minute = 0 , second =0;
        hour = secondDiff / 3600;
        minute = (secondDiff - 3600 * hour) / 60;
        second = (secondDiff - 3600 * hour - 60 * minute);
        Instant current = Instant.now();
        Output.append("距离高考成绩公布还有"+hour+"小时"+minute+"分钟"+second+"秒！");
        SendMessage(223885758,Output.toString(),false);
        System.out.println(Output.toString());
    }
}
