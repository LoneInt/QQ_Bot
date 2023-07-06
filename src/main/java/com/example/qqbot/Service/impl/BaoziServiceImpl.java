package com.example.qqbot.Service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import static com.example.qqbot.API.ApiUtil.SendMessage.SendMessage;
import com.example.qqbot.Events.Entity.MessageEventParam;
import com.example.qqbot.Service.InterFace.BaoziService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.simpleframework.xml.util.Match;
import org.springframework.stereotype.Service;

import org.jsoup.nodes.Document;

import java.beans.Encoder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.qqbot.Util.SendHttpRequest.sendHttpRequest;
import static com.example.qqbot.Util.TexttoAudioUtil.TextConvert;


@Service
public class BaoziServiceImpl implements BaoziService {
    @Override
    public void GetBaozi(MessageEventParam messageEventParam) {
        String BaoziUrl = "http://news.cnr.cn/mryxh/";
        String temp = new String();
        try {
            URL url = new URL(BaoziUrl);
            Document document = Jsoup.parse(url, 20000);
            Elements script = document.getElementsByTag("script");
            JSONArray jsonArray = new JSONArray();
            int i = 0;
            for (Element em : script) {
                if (i == 2) {
                    //System.out.println(em);
                    String scriptContent = em.html();
                    int beginindex = scriptContent.indexOf("[");
                    int endindex = scriptContent.indexOf("]");
                    System.out.println("begin: " + beginindex + "\n" + endindex);
                    temp = scriptContent.substring(beginindex, endindex + 1);
                    break;
                } else {
                    i++;
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        JSONArray jsonArray = JSONArray.parseArray(temp);
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        String link = jsonObject.getString("link");
        try {
            Document document = Jsoup.connect(link)
                    .header("Content-Type", "text/html;charset=gb2312").get();
            Elements elements = document.getElementsByTag("p");
            //System.out.println("***********************"+elements);
            StringBuilder output = new StringBuilder();
            try {
                System.out.println("************************");
                for(Element em : elements){
                    System.out.println(em);
                    output.append(em.text()+"\n"+"  ");
                    //TextConvert(em.text());
                }
                SendMessage(messageEventParam.getGroup_id(), output.toString(), false);
            } catch (Exception e) {
                System.out.println("12312");
            }
        }catch (Exception e){

        }
    }
}
