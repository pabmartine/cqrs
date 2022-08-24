package com.example.cqrs.infrastructure;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.model.DataRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MyDataRepository implements DataRepository {

	List<Data> dataList;

	public MyDataRepository() {
		this.dataList = new ArrayList<>();
	}

	@Override
	public void save(Data data) {
		dataList.add(data);
	}

	@Override
	public Optional<Data> findById(String id) {
		return dataList.stream().filter(d -> d.getId().equals(id)).findFirst();
	}
}