package com.example.cqrs.domain.events;

import com.example.cqrs.domain.bus.Event;
import lombok.Builder;

@lombok.Data
@Builder
public class DataEvent implements Event {
	private String id;
	private String value;
}
