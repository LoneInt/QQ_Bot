package com.example.qqbot.Service.impl;

import com.example.qqbot.Events.Entity.MessageEventParam;
import com.example.qqbot.Service.InterFace.RepeatingMachService;
import org.springframework.stereotype.Service;

import static com.example.qqbot.API.ApiUtil.SendMessage.SendMessage;

@Service
public class RepeatingMachServiceImpl implements RepeatingMachService {
    public void RepeatingMsg(MessageEventParam messageEventParam)
    {
        if(messageEventParam.getMessage().equals("test") && messageEventParam.getUser_id() == 997681352)
        SendMessage(messageEventParam.getGroup_id(),"test",false);
    }

}
