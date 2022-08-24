package com.example.cqrs.domain.model;

import com.example.cqrs.domain.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataService {

	@Autowired
	private DataRepository dataRepository;
	@Autowired
	private EventBus eventBus;

	public void add(Data data) throws Exception {
		dataRepository.save(data);
		eventBus.publish(data);
	}
}