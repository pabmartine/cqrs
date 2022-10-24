package com.example.cqrs.application.add;

import com.example.cqrs.domain.events.DataEvent;
import com.example.cqrs.domain.ports.bus.EventBus;
import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.ports.repository.CommandDataRepository;
import com.example.cqrs.domain.ports.usecase.AddCommandDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddDataUseCaseImpl implements AddCommandDataUseCase {

	@Autowired
	private CommandDataRepository commandDataRepository;
	@Autowired
	private EventBus eventBus;

	public void add(Data data) throws Exception {
		commandDataRepository.save(data);
		eventBus.publish(DataEvent.builder().id(data.getId()).value(data.getValue()).build());
	}
}