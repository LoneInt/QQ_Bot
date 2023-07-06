package com.example.qqbot.Util.WeatherUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class WeatherJSONParse {
    public static Map<String,String> WeatherJSON(JSONObject jsonObject){
        Map<String,String> result = new HashMap<>();
        result.put("address",jsonObject.getString("address"));
        JSONArray jsonArray = jsonObject.getJSONArray("days");
        result.put("datetime",jsonArray.getJSONObject(0).getString("datetime"));
        result.put("temp",jsonArray.getJSONObject(0).getString("temp"));
        result.put("feelslike",jsonArray.getJSONObject(0).getString("feelslike"));
        result.put("conditions",jsonArray.getJSONObject(0).getString("conditions"));
        result.put("description",jsonArray.getJSONObject(0).getString("description"));
        return result;
    }
}
