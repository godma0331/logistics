package com.mjj.config;

import org.omg.SendingContext.RunTime;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * @Author: mjj
 * @Date:
 * @Description:
 * @version: 1.0
 */
@Configuration
public class BrowerAutoConfig {
    @EventListener({ApplicationReadyEvent.class})
    public void applicationReadyEvent(){
        String url = "http://localhost";
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd   /c  start   "+url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
