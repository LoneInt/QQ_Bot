package com.example.qqbot.API.ApiUtil;

import com.alibaba.fastjson.JSONObject;
import com.example.qqbot.API.Param.SendMessageP.SendMessageParamData;
import com.example.qqbot.API.Param.SendMessageP.SendMessageParam;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.TimeZone;

import static com.example.qqbot.Util.SendHttpRequest.sendHttpRequest;

public class SendMessage {
    public static int SendMessage(int group_id,String message,boolean auto_escape)
    {
        System.out.println("SENDING");
        StringBuilder temp = new StringBuilder();
        temp.append("group_id=").append(group_id);
        temp.append("&message=").append(URLEncoder.encode(message, StandardCharsets.UTF_8));
        temp.append("&auto_escape").append(auto_escape);
        System.out.println("temp:"+temp+"\n");
        SendMessageParam sendGroupMsgParam = JSONObject.parseObject(sendHttpRequest("http://127.0.0.1:8077/send_group_msg?" + temp,true), SendMessageParam.class);
        try{
            System.out.println("send group message :"+message);
            return Integer.parseInt(sendGroupMsgParam.getData().getMessage_id());
        }catch (Exception e){
            return -1;
        }
    }
}
