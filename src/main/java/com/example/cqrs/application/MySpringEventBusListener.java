package com.example.cqrs.application;

import com.example.cqrs.domain.eventbus.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MySpringEventBusListener {


    @EventListener
    public void handle(Event event) throws Exception {
        log.info("Received {} event", event.getClass().getName());
    }
}