package com.example.cqrs;

import com.example.cqrs.application.get.GetDataQueryDto;
import com.example.cqrs.domain.ports.bus.CommandBus;
import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.ports.bus.QueryBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		Data data = queryBus.handle(GetDataQueryDto.builder().id(dataId).build());
		log.info(data != null ? "Found: " + data.getId() : "Not Found");

		log.info("**** Adding ****");
		commandBus.handle(AddDataCommandDto.builder().id(dataId).value(dataValue).build());

		log.info("**** Second query ****");
		data = queryBus.handle(GetDataQueryDto.builder().id(dataId).build());
		log.info(data != null ? "Found: " + data.getId() : "Not Found");

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CqrsApplication.class, args);
	}
}
