package com.example.cqrs.domain.eventbus;

public interface EventBus {

	void publish(Event e);

}