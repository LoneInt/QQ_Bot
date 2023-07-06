package com.example.qqbot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.example.qqbot.Util.ParamConvert.MessageEventParaConvert;

@CrossOrigin
@RestController
public class GlobalController {
    @Autowired
    private MessageHandler messageHandler;




    @PostMapping("/")
    public void globalController(@RequestBody Map<String,Object> paramsMap)
    {
        //autoUploadRMDailyService.AutoUploadRMDaily(GROUP_ID);
        switch (paramsMap.get("post_type").toString())
        {
            case"message":
                messageHandler.MessageHandler(MessageEventParaConvert(paramsMap));
                break;
        }
    }
}
