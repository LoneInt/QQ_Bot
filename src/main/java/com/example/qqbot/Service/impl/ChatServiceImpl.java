package com.example.qqbot.Service.impl;

import com.example.qqbot.API.Param.ChatGptParam.ConfigParam;
import com.example.qqbot.API.Param.ChatGptParam.SendMsgParam;
import com.example.qqbot.Events.Entity.MessageEventParam;
import com.example.qqbot.Service.InterFace.ChatService;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


@Component
public class ChatServiceImpl implements ChatService {
    private ConfigParam configParam;
    private SendMsgParam sendMsgParam;
    @Override
    public void Chat(MessageEventParam messageEventParam) {
        String text = messageEventParam.getMessage().replace("/sb","");
        HttpPost httpPost = new HttpPost(configParam.getApiUrl());
        CloseableHttpClient client = HttpClients.createDefault();
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer " + configParam.getApiKey());
        Map<String,String> temp =new HashMap<>();
        temp.put("model",sendMsgParam.getModel());
        temp.put("prompt","HelloWorld!");
        temp.put("max_tokens","8");
        System.out.println(temp);
    }
}
