package com.example.qqbot.Util.BlogUtils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetBlogImgUtil {
    public static String GetBlogImg(String WeiboUrl){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(WeiboUrl);
        HttpResponse response = null;
        String ImgUrl = new String();
        try {
            response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() == 200)
            {
                String Content = EntityUtils.toString(response.getEntity());
                System.out.println(Content);
            }
            else System.out.println(response.getStatusLine().getStatusCode());
        }catch (Exception e){
            System.out.println("ERROR");
        }


        return "";
    }
}
