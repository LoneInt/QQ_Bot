package com.example.qqbot.Service.impl;

import com.example.qqbot.API.ApiUtil.SendMessage;
import com.example.qqbot.Events.Entity.MessageEventParam;
import com.example.qqbot.Service.InterFace.TopSearchService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import static com.example.qqbot.API.ApiUtil.SendMessage.SendMessage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
@Service
public class TopSearchServiceImpl implements TopSearchService {
    @Override
    public void TopSearch(MessageEventParam messageEventParam) {

        String temp = "https://top.baidu.com/board?tab=realtime";
        StringBuilder Output = new StringBuilder();
        Output.append("今日百度热搜榜"+"\n");
        try{
            URL requestURL = new URL(temp);
            Document document = Jsoup.parse(requestURL, 20000);
            Element element = document.getElementById("sanRoot");
            //System.out.println(element.html());
            Elements elements = element.getElementsByClass("category-wrap_iQLoo horizontal_1eKyQ");
            String result = new String();
            int cnt = 1;
            for (Element temp1 : elements) {
                result = temp1.getElementsByClass("c-single-text-ellipsis").text();
                Output.append(cnt+"."+result+"\n");
                cnt++;
                if(cnt == 21) break;
            }
            SendMessage(messageEventParam.getGroup_id(),Output.toString(),false);
        }catch (Exception e)
        {
            System.out.println("CNM");
        }
    }
    }
