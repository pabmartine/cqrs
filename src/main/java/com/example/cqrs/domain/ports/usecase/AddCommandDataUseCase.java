package com.example.cqrs.domain.ports.usecase;

import com.example.cqrs.domain.model.Data;

public interface AddCommandDataUseCase {

	void add(Data commandData) throws Exception;
}
