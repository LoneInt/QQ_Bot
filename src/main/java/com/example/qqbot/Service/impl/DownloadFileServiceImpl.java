package com.example.qqbot.Service.impl;

import com.example.qqbot.Service.InterFace.DownloadFIleService;
import com.example.qqbot.Util.SendHttpRequest;
import org.springframework.stereotype.Service;

import static com.example.qqbot.Util.SendHttpRequest.sendHttpRequest;
import static com.example.qqbot.Util.SendHttpRequestText.sendHttpRequestText;

@Service
public class DownloadFileServiceImpl implements DownloadFIleService {
    @Override
    public String DownloadFile(String Url) {
        sendHttpRequestText(Url.toString(),true);
        return sendHttpRequestText(Url.toString(),true);
    }
}
