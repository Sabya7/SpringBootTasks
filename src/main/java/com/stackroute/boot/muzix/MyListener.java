package com.stackroute.boot.muzix;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyListener implements ApplicationListener<ApplicationStartedEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
            System.out.println("EVEEEEEEEEEEEEEEEEEEEEEEEEEENNNNNNNNNNNNTTTTTTTTT");

    }
}
