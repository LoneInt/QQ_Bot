package com.example.qqbot.Controller;

import com.example.qqbot.Events.Entity.MessageEventParam;
import com.example.qqbot.Service.InterFace.RepeatingMachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MessageHandler {
    @Autowired
    private FunctionHandler functionHandler;
//        @RequestMapping("/")
//        public String GetMessage(@RequestBody Map<String,Object> Singapore){
//
//            System.out.println(Singapore.get("message"));
//            return (String) Singapore.get("message");
//        }
    @Autowired
        private RepeatingMachService repeatingMachService;

        public void MessageHandler(MessageEventParam messageEventParam)
        {
                    System.out.println("Message: "+messageEventParam.getMessage());
                    System.out.println();
                    //forwardMessageService.ForwardMessage(messageEventParam);
                    if(messageEventParam.getMessage().startsWith("/"))
                        functionHandler.FunctionHandler(messageEventParam);
                    else
                        repeatingMachService.RepeatingMsg(messageEventParam);
        }

}
