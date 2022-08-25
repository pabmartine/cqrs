package com.example.cqrs.infrastructure.adapters.in.queryhandler;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.ports.bus.querybus.QueryHandler;
import com.example.cqrs.domain.ports.usecase.FindQueryDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetDataQueryHandler implements QueryHandler<Data, GetDataQuery> {

	@Autowired
	private FindQueryDataUseCase findQueryDataUseCase;

	@Override
	public Data handle(GetDataQuery query) throws Exception {
		return findQueryDataUseCase.findById(query.getId()).orElse(null);
	}
}