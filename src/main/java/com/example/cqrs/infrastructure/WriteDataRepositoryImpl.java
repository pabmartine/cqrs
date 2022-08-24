package com.example.cqrs.infrastructure;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.model.WriteDataRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WriteDataRepositoryImpl implements WriteDataRepository {

	List<Data> dataList;

	public WriteDataRepositoryImpl() {
		this.dataList = new ArrayList<>();
	}

	@Override
	public void save(Data data) {
		dataList.add(data);
	}

}