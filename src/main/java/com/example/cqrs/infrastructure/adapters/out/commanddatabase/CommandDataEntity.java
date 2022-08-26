package com.example.cqrs.infrastructure.adapters.out.commanddatabase;

import lombok.Builder;

@lombok.Data
@Builder
public class CommandDataEntity {
	private String id;
	private String value;
}
