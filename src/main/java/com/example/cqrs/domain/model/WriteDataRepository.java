package com.example.cqrs.domain.model;

public interface WriteDataRepository {
	void save(Data data);

}