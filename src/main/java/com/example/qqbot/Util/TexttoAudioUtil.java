package com.example.qqbot.Util;

import static com.example.qqbot.API.ApiUtil.SendMessage.SendMessage;

public class TexttoAudioUtil {
    public static void TextConvert(String text){
        StringBuilder Output = new StringBuilder();;
        Output.append("[CQ:tts,text="+text+"]");
        SendMessage(223885758,Output.toString(),false);
    }
}
