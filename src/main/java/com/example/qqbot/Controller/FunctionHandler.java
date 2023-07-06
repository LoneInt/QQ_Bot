package com.example.qqbot.Controller;

import com.example.qqbot.Events.Entity.MessageEventParam;
import com.example.qqbot.Service.InterFace.*;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FunctionHandler {
    @Autowired
    private GetHXJBlogService getHXJBlogService;
    @Autowired
    private WeatherService weatherService;
    @Autowired
    TopSearchService topSearchService;
@Autowired
    TextToAudioService textToAudioService;
    @Autowired
    CountDownService countDownService;
    @Autowired
    ChatService chatService;
    @Autowired
    BaoziService baoziService;
    public void FunctionHandler(MessageEventParam messageEventParam)
    {
        final String msg = messageEventParam.getMessage();
        if(msg.startsWith("/weather"))   weatherService.GetWeather(messageEventParam);
        if(msg.startsWith("/sb"))   chatService.Chat(messageEventParam);
        if(msg.startsWith("/top"))   topSearchService.TopSearch(messageEventParam);
        if(msg.startsWith("/weibo"))    getHXJBlogService.getHXJBlog(messageEventParam);
        if(msg.startsWith("/audio"))  textToAudioService.TextToAudio(messageEventParam);
        if(msg.startsWith("/rnm"))    baoziService.GetBaozi(messageEventParam);
    }
}
