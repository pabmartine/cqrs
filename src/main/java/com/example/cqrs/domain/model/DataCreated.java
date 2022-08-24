package com.example.cqrs.domain.model;

import com.example.cqrs.domain.eventbus.Event;
import lombok.Builder;

@lombok.Data
@Builder
public class DataCreated implements Event {
	private String id;
	private String value;
}
