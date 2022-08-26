package com.example.cqrs.infrastructure.adapters.in.querybus;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.ports.usecase.FindQueryDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetDataQueryHandler implements QueryBusHandler<Data, GetDataQueryDto> {

	@Autowired
	private FindQueryDataUseCase findQueryDataUseCase;

	@Override
	public Data handle(GetDataQueryDto query) throws Exception {
		return findQueryDataUseCase.findById(query.getId()).orElse(null);
	}
}