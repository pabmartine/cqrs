package com.example.cqrs.domain.ports.repository;

import com.example.cqrs.domain.model.Data;

import java.util.Optional;

public interface QueryDataRepository {

	void save(Data queryData);

	Optional<Data> findById(String id);

}