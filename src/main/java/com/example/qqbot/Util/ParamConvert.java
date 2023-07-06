package com.example.qqbot.Util;

import com.example.qqbot.Events.Entity.MessageEventParam;

import java.util.Map;

public class ParamConvert {
    public static MessageEventParam MessageEventParaConvert(Map paramMap)
    {
        MessageEventParam messageEventParam = new MessageEventParam();
        try {
            messageEventParam.setUser_id((Long) paramMap.get("user_id"));
        }catch (Exception e){
            Integer integerId = ((Integer) paramMap.get("user_id"));
            messageEventParam.setUser_id(integerId.longValue());
        }
        messageEventParam.setMessage((String) paramMap.get("message"));
        try{
            messageEventParam.setGroup_id((Integer) paramMap.get("group_id"));
        }catch (Exception ignored){}
        //messageEventParam.setSender(new Sender((String)((Map)(paramMap.get("sender"))).get("nickname")));
        return messageEventParam;
    }
    }
