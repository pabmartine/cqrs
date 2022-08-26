package com.example.cqrs.domain.ports.bus;

import com.example.cqrs.domain.bus.Event;

public interface EventBus {

	void publish(Event e);

}