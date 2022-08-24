package com.example.cqrs.domain.model;

import java.util.Optional;

public interface DataRepository {
	void save(Data data);

	Optional<Data> findById(String id);

}