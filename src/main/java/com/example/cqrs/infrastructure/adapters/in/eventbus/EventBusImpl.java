package com.example.cqrs.infrastructure.adapters.in.eventbus;

import com.example.cqrs.domain.bus.Event;
import com.example.cqrs.domain.ports.bus.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Primary
public class EventBusImpl implements EventBus {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(Event event) {
        log.info("Published {} event", event.getClass().getName());
        applicationEventPublisher.publishEvent(event);
    }
}