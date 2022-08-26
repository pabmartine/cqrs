package com.example.cqrs.infrastructure.adapters.in.querybus;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.bus.Query;
import lombok.Builder;

@lombok.Data
@Builder
public class GetDataQueryDto extends Query<Data> {

	private String id;
}
