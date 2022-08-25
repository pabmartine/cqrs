package com.example.cqrs.infrastructure.adapters.out.querydatabase;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.ports.repository.QueryDataRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class QueryDataRepositoryImpl implements QueryDataRepository {

	List<QueryData> dataList;

	public QueryDataRepositoryImpl() {
		this.dataList = new ArrayList<>();
	}

	@Override
	public void save(Data data) {
		dataList.add(QueryData.builder().id(data.getId()).value(data.getValue()).build());
	}

	@Override
	public Optional<Data> findById(String id) {
		return dataList.stream().filter(d -> d.getId().equals(id)).findFirst().map(s -> Data.builder().id(s.getId()).value(s.getValue()).build());
	}
}