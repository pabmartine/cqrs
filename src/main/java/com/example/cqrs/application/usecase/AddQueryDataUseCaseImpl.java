package com.example.cqrs.application.usecase;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.ports.repository.QueryDataRepository;
import com.example.cqrs.domain.ports.usecase.AddQueryDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddQueryDataUseCaseImpl implements AddQueryDataUseCase {

	@Autowired
	private QueryDataRepository queryDataRepository;

	public void add(Data queryData) throws Exception {
		queryDataRepository.save(queryData);
	}
}