package com.example.cqrs.infrastructure.adapters.in.eventbuslistener;

import com.example.cqrs.domain.events.DataEvent;
import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.ports.usecase.AddQueryDataUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataEventBusListener extends MySpringEventBusListener<DataEvent> {

	@Autowired
	private AddQueryDataUseCase addQueryDataUseCase;

	@Override
	protected void handle(DataEvent event) throws Exception {
		addQueryDataUseCase.add(Data.builder().id(event.getId()).value(event.getValue()).build());
	}
}