package com.example.qqbot.Events.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
public class MessageEventParam {

    private String message_type;
    private String message_id;
    private long user_id;
    private String message;
    private String raw_message;
    private int group_id;


}
