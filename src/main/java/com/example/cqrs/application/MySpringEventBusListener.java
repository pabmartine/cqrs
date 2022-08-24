package com.example.cqrs.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public abstract class MySpringEventBusListener<T> {

	protected abstract void handle(T t) throws Exception;

	@EventListener
	private void listener(T t) throws Exception {
		log.info("Received {} event", t.getClass().getName());
		this.handle(t);
	}
}

