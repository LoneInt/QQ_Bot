package com.example.qqbot.API.Param.ChatGptParam;

import com.example.qqbot.Events.Entity.ChatBotEntity.Choice;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SendMsgParam {
    private final String model = "gpt-3.5-turbo";
    private List<Choice> message;
    private final int n = 1;
    private String prompt;
    private int max_tokens;
    private final double temperature = 0.8 ;
    private final String stream = "false";
    private final String logprobs = null;
    private final String stop = "\n";


}
