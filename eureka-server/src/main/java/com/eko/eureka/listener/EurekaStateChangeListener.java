package com.eko.eureka.listener;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component  
public class EurekaStateChangeListener {  
  
//    @Autowired  
//    private EmailLogService emailLogService;  
  
    @EventListener  
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {  
  
        String appName = eurekaInstanceCanceledEvent.getAppName();  
        String serverId = eurekaInstanceCanceledEvent.getServerId();  
        System.out.println(appName);  
        System.out.println(serverId);  
        String message = LocalDateTime.now()+"\r\n"+appName+"\r\n"+serverId;  
        //emailLogService.sendMail(message);  
  
    }  
} 