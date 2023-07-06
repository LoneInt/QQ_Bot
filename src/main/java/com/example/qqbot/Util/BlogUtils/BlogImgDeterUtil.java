package com.example.qqbot.Util.BlogUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class BlogImgDeterUtil {
    public static String BlogImgDeter(String WeiboUrl){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(WeiboUrl);
        HttpResponse response = null;
        String Content = new String();
        try {
            response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK){
                Content = EntityUtils.toString(response.getEntity());
            }
            else System.out.println(response.getStatusLine().getStatusCode());
       }catch (Exception e){

       }finally {
            try {
                httpClient.close();
            }catch (Exception e ){

            }
        }
        JSONObject jsonObject = JSON.parseObject(Content);
        JSONObject Data = jsonObject.getJSONObject("data");
        JSONArray Cards = Data.getJSONArray("cards");
        Map<String,Object> temp = (Map<String, Object>) Cards.getJSONObject(0).getJSONObject("mblog");
        if(temp.get("bmiddle_pic") == null) return  null;
        else return temp.get("bmiddle_pic").toString();
    }
}
