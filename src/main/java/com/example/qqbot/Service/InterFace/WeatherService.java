package com.example.qqbot.Service.InterFace;

import com.example.qqbot.Events.Entity.MessageEventParam;
import org.springframework.stereotype.Service;


public interface WeatherService {
    void GetWeather(MessageEventParam messageEventParam);
}
