package com.example.qqbot.TimerTask;


import com.example.qqbot.Service.InterFace.CountDownService;
import com.example.qqbot.Service.impl.TimerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
//@Component
//public class TimeTask extends TimerTask {
//    private AutoUploadRMDailyService autoUploadRMDailyService;
//    @Override
//    //@Scheduled(cron = "* * * * * ?")
//    public void run() {
//        autoUploadRMDailyService.AutoUploadRMDaily(GROUP_ID);
//        System.out.println("\n"+"RUN!!!");
//    }
//}



@Component
public class TimeTask implements Runnable{
    @Autowired
    private TimerServiceImpl timerService;
    @Autowired
    private CountDownService countDownService;
    @Override
    @Scheduled(cron = "30 0 * * * ?")
    @Scheduled(cron = "30 30 0,6,12,18 * * ?")
    //@Scheduled(fixedRate = 1500)
    public void run() {
        System.out.println("RUN!!!");
        timerService.Count();

    }
}

