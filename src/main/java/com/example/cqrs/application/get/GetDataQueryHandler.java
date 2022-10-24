package com.example.cqrs.application.get;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.ports.usecase.FindQueryDataUseCase;
import com.example.cqrs.domain.bus.QueryBusHandler;
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