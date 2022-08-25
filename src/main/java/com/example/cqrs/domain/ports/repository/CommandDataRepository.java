package com.example.cqrs.domain.ports.repository;

import com.example.cqrs.domain.model.Data;

public interface CommandDataRepository {
	void save(Data commandData);

}