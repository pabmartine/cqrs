package com.example.cqrs.infrastructure.adapters.out.querydatabase;

import com.example.cqrs.domain.bus.Event;
import lombok.Builder;

@lombok.Data
@Builder
public class QueryData implements Event {
	private String id;
	private String value;
}
