package com.example.qqbot.Service;

import jakarta.servlet.http.HttpServletRequest;

public abstract interface QQbotService {
    public void QQbotEvenHandle(HttpServletRequest request);
}
