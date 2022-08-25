package com.example.cqrs.domain.ports.usecase;

import com.example.cqrs.domain.model.Data;

public interface AddQueryDataUseCase {

	void add(Data queryData) throws Exception;

}
