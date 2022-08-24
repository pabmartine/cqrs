package com.example.cqrs.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReadDataService {

	@Autowired
	private ReadDataRepository readDataRepository;

	public void add(DataCreated dataCreated) throws Exception {
		readDataRepository.save(dataCreated);
	}
}