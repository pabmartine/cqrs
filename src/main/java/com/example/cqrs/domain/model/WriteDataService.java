package com.example.cqrs.domain.model;

import com.example.cqrs.domain.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class WriteDataService {

	@Autowired
	private WriteDataRepository writeDataRepository;
	@Autowired
	private EventBus eventBus;

	public void add(Data data) throws Exception {
		writeDataRepository.save(data);
		eventBus.publish(DataCreated.builder().id(data.getId()).value(data.getValue()).build());
	}
}