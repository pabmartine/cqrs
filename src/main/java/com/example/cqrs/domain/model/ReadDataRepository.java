package com.example.cqrs.domain.model;

import java.util.Optional;

public interface ReadDataRepository {

	void save(DataCreated dataCreated);

	Optional<DataCreated> findById(String id);

}