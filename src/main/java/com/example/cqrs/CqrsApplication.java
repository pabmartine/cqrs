package com.example.cqrs;

import com.example.cqrs.application.data.AddDataCommand;
import com.example.cqrs.application.data.GetDataQuery;
import com.example.cqrs.domain.commandbus.CommandBus;
import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.model.DataCreated;
import com.example.cqrs.domain.querybus.QueryBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@Slf4j
@SpringBootApplication
public class CqrsApplication implements CommandLineRunner {

	@Autowired
	private QueryBus queryBus;

	@Autowired
	private CommandBus commandBus;

	@Override
	public void run(String... args) throws Exception {

		String dataId = "1";
		String dataValue = "abc";

		log.info("**** First query ****");
		DataCreated data = queryBus.handle(GetDataQuery.builder().id(dataId).build());
		log.info(data != null ? "Found: " + data.getId() : "Not Found");

		log.info("**** Adding ****");
		commandBus.handle(AddDataCommand.builder().data(Data.builder().id(dataId).value(dataValue).build()).build());

		log.info("**** Second query ****");
		data = queryBus.handle(GetDataQuery.builder().id(dataId).build());
		log.info(data != null ? "Found: " + data.getId() : "Not Found");

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CqrsApplication.class, args);
	}
}
