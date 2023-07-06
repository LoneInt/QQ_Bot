package com.example.qqbot.Service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.qqbot.API.ApiUtil.SendMessage;
import com.example.qqbot.API.Param.HXJBlogParam.HXJBlogParam;
import com.example.qqbot.Events.Entity.MessageEventParam;
import com.example.qqbot.Service.InterFace.GetHXJBlogService;
import com.example.qqbot.Util.BlogUtils.BlogImgDeterUtil;
import com.example.qqbot.Util.ImgURLConvertBase64Util;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Service;
import  com.example.qqbot.Util.*;
import static com.example.qqbot.API.ApiUtil.SendMessage.SendMessage;
import static com.example.qqbot.Util.BlogUtils.BlogImgDeterUtil.BlogImgDeter;
import static com.example.qqbot.Util.ImgURLConvertBase64Util.ImgConvertBase64;
import java.io.IOException;
import static com.example.qqbot.CommonURL.ParamCommon.HXJBlog_URL;
import static com.example.qqbot.Util.SendHttpRequest.sendHttpRequest;
@Service
public class GetHXJBlogServiceImpl implements GetHXJBlogService {
    public void getHXJBlog(MessageEventParam messageEventParam) {
        //Get the ID of the latest post
        String WeiboURL1 =
                "https://m.weibo.cn/api/container/getIndex?t=0&luicode=10000011&lfid=100103type%3D1%26q%3D%E8%83%A1%E9%94%A1%E8%BF%9B&type=uid&value=1989660417&containerid=1076031989660417";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(WeiboURL1);
        String Content = new String();
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                Content = EntityUtils.toString(response.getEntity());
                System.out.println(Content);
            } else System.out.println(response.getStatusLine().getStatusCode());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        //Parse the json to get ID
        JSONObject jsonObject = JSON.parseObject(Content);
        JSONObject Data = jsonObject.getJSONObject("data");
        System.out.println(Data);
        JSONArray Cards = Data.getJSONArray("cards");
        JSONObject jo = (JSONObject) Cards.get(0);
        JSONObject Mblog = jo.getJSONObject("mblog");
        String ID = Mblog.getString("id");
        System.out.println(ID);
        StringBuilder AimURL = new StringBuilder();
        AimURL.append("https://m.weibo.cn/statuses/extend?")
                .append("id="+ID);
        System.out.println("\n"+"AIm"+AimURL);
        HttpGet get = new HttpGet(AimURL.toString());
        CloseableHttpClient Client = HttpClients.createDefault();
        String cnm = new String();
        try {
            response = Client.execute(get);
            if (response.getStatusLine().getStatusCode() == 200) {
                Content = EntityUtils.toString(response.getEntity());
                System.out.println(Content);
            } else System.out.println(response.getStatusLine().getStatusCode());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                Client.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            //Parse the json to get the whole post
            JSONObject DATA = JSON.parseObject(Content);
            JSONObject TEMP = DATA.getJSONObject("data");
            System.out.println("\n"+TEMP);
            String output = TEMP.getString("longTextContent");
            cnm = output.replace("<br />","\n");
            System.out.println("\n"+cnm);
        }
        String ImgURl = BlogImgDeter(WeiboURL1);
        if(ImgURl != null) {
            StringBuilder sb = new StringBuilder();
            String Output = ImgConvertBase64(ImgURl);
            sb.append(cnm);
            sb.append("[CQ:image,file=base64://" + Output + "]");
            String rnm = sb.toString().replace("<br />", "\n");

            SendMessage(223885758, rnm, false);
        }
        else {
            SendMessage(223885758, cnm, false);
            System.out.println("No Image Found!");
        }
        }
    }

