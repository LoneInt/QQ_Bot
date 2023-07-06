package com.example.qqbot.Service.impl;

import com.example.qqbot.API.ApiUtil.SendMessage;
import com.example.qqbot.Events.Entity.MessageEventParam;
import com.example.qqbot.Service.InterFace.CheerUpService;
import org.springframework.stereotype.Service;

import static com.example.qqbot.CommonURL.ParamCommon.LanCL;
import static com.example.qqbot.API.ApiUtil.SendMessage.SendMessage;


@Service
public class CheerUpServiceImpl implements CheerUpService {
    @Override
    public void CheerUp() {
        StringBuilder Output = new StringBuilder();
        Output.append("[CQ:at,qq="+
                        String.valueOf(LanCL).toString()+
                        "]"+
                        "蓝陈琳加油哦！"
        );
        SendMessage(223885758,Output.toString(),false);
        System.out.println("Cheer!!!");
    }
}
