package com.example.qqbot.Service.impl;

import com.example.qqbot.API.ApiUtil.SendMessage;
import com.example.qqbot.Events.Entity.MessageEventParam;
import com.example.qqbot.Service.InterFace.TextToAudioService;
import org.springframework.stereotype.Service;

import static com.example.qqbot.API.ApiUtil.SendMessage.SendMessage;

@Service
public class TextToAudioServiceImpl implements TextToAudioService {
    @Override
    public void TextToAudio(MessageEventParam messageEventParam) {
        StringBuilder Output = new StringBuilder();
        String text = messageEventParam.getMessage().replace("/audio","");
        Output.append("[CQ:tts,text="+text+"]");
        SendMessage(223885758,Output.toString(),false);
        }
}
