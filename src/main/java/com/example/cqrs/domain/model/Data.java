package com.example.cqrs.domain.model;

import com.example.cqrs.domain.bus.Command;
import lombok.Builder;

@lombok.Data
@Builder
public class Data extends Command {
	private String id;
	private String value;
}
