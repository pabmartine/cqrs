package com.example.cqrs.infrastructure.adapters.in.queryhandler;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.bus.Query;
import lombok.Builder;

@lombok.Data
@Builder
public class GetDataQuery extends Query<Data> {

	private String id;
}
