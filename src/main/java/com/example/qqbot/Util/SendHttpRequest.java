package com.example.qqbot.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class SendHttpRequest {
    public static String sendHttpRequest(String urlParam,boolean autoJump){
        try {
            URL url = new URL(urlParam);
            System.out.println("URL:　"+urlParam);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setInstanceFollowRedirects(autoJump);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "text/json;charset=utf-8");
            connection.setRequestProperty("Cookie","");
            // 获取响应头
            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();
                for (String value : values) {
                    System.out.println(key + ": " + value);
                }
            }
            // 读取响应内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();
            String response = responseBuilder.toString();
            System.out.println("Response: " + response);
            if(autoJump){
                return response;
            }else {
                return headers.get("Location").get(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
