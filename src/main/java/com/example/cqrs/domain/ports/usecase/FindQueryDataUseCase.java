package com.example.cqrs.domain.ports.usecase;

import com.example.cqrs.domain.model.Data;

import java.util.Optional;

public interface FindQueryDataUseCase {

	Optional<Data> findById(String id);
}
