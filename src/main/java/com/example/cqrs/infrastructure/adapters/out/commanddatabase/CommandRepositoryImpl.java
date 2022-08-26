package com.example.cqrs.infrastructure.adapters.out.commanddatabase;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.ports.repository.CommandDataRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CommandRepositoryImpl implements CommandDataRepository {

	List<CommandDataEntity> dataList;

	public CommandRepositoryImpl() {
		this.dataList = new ArrayList<>();
	}

	@Override
	public void save(Data data) {
		dataList.add(CommandDataEntity.builder().id(data.getId()).value(data.getValue()).build());
	}

}