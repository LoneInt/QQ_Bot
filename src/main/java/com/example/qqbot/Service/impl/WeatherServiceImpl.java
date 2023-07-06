package com.example.qqbot.Service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.qqbot.API.ApiUtil.SendMessage;
import com.example.qqbot.API.Param.Weather.WeatherParam;
import com.example.qqbot.Events.Entity.MessageEventParam;
import com.example.qqbot.Service.InterFace.WeatherService;
import com.example.qqbot.Util.WeatherUtil.WeatherJSONParse;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import static com.example.qqbot.Util.WeatherUtil.WeatherJSONParse.WeatherJSON;
import static com.example.qqbot.API.ApiUtil.SendMessage.SendMessage;
import static com.example.qqbot.CommonURL.ParamCommon.Weather_URL;
import static com.example.qqbot.Util.SendHttpRequest.sendHttpRequest;

@Service
public class WeatherServiceImpl implements WeatherService {


    public void GetWeather(MessageEventParam messageEventParam)
    {
        StringBuilder Output = new StringBuilder();
        StringBuilder WeatherUrl = new StringBuilder();
        String city = messageEventParam.getMessage().replace("/weather ","");
        System.out.println("City: "+city.toString());
        WeatherUrl.append("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" +
                city +
                "?unitGroup=us&key=EDC99Z85EB5BF43YRTNTW8WPF&contentType=json");
        try{
        JSONObject temp = JSONObject.parseObject(sendHttpRequest(WeatherUrl.toString(),true));
        System.out.println("----------------%0A"+temp);
        Map<String,String> item = WeatherJSON(temp);
        Output.append("Address: "+item.get("address")+"\n")
                .append("The date: "+item.get("datetime")+"\n")
                .append("The temperature is "+item.get("temp")+"℉"+"\n")
                .append("The apparent temperature is "+item.get("feelslike")+"℉"+"\n")
                .append("The weather condition today is "+item.get("conditions")+"\n")
                .append(item.get("description")+"\n"+"Have a nice day!");
        SendMessage(messageEventParam.getGroup_id(),Output.toString(),false);
        }catch (Exception e){
            System.out.println("+++++++++++++++++++++++++++");
            SendMessage(messageEventParam.getGroup_id(),"Error!",false);
        }

    }

}
