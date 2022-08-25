package com.example.cqrs.application.usecase;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.ports.repository.QueryDataRepository;
import com.example.cqrs.domain.ports.usecase.FindQueryDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindQueryDataUseCaseImpl implements FindQueryDataUseCase {

	@Autowired
	private QueryDataRepository queryDataRepository;

	@Override
	public Optional<Data> findById(String id) {
		return queryDataRepository.findById(id);
	}
}