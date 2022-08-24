package com.example.cqrs.infrastructure;

import com.example.cqrs.domain.eventbus.Event;
import com.example.cqrs.domain.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Slf4j
@Component("SpringEventBus")
@Primary
public class SpringEventBus implements EventBus {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(Event event) {
        log.info("Published {} event", event.getClass().getName());
        applicationEventPublisher.publishEvent(event);
    }
}