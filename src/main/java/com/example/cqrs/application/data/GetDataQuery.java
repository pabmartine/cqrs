package com.example.cqrs.application.data;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.model.DataCreated;
import com.example.cqrs.domain.querybus.Query;
import lombok.Builder;

@lombok.Data
@Builder
public class GetDataQuery extends Query<DataCreated> {

	private String id;
}
