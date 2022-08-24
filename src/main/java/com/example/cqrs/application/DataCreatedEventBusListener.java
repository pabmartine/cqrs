package com.example.cqrs.application;

import com.example.cqrs.domain.model.DataCreated;
import com.example.cqrs.domain.model.ReadDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataCreatedEventBusListener extends MySpringEventBusListener<DataCreated> {

	@Autowired
	private ReadDataService readDataService;

	@Override
	protected void handle(DataCreated dataCreated) throws Exception {
		readDataService.add(dataCreated);
	}
}