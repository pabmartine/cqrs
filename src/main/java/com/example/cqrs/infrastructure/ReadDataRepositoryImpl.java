package com.example.cqrs.infrastructure;

import com.example.cqrs.domain.model.DataCreated;
import com.example.cqrs.domain.model.ReadDataRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReadDataRepositoryImpl implements ReadDataRepository {

	List<DataCreated> dataList;

	public ReadDataRepositoryImpl() {
		this.dataList = new ArrayList<>();
	}

	@Override
	public void save(DataCreated dataCreated) {
		dataList.add(dataCreated);
	}

	@Override
	public Optional<DataCreated> findById(String id) {
		return dataList.stream().filter(d -> d.getId().equals(id)).findFirst();
	}
}