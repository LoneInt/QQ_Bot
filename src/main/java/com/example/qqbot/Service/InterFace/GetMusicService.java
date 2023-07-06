package com.example.qqbot.Service.InterFace;

import com.example.qqbot.Events.Entity.MessageEventParam;
import com.unfbx.chatgpt.entity.chat.Message;

public interface GetMusicService {
    void GetMusic(MessageEventParam messageEventParam);
}
