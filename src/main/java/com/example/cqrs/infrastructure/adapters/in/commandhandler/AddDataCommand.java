package com.example.cqrs.infrastructure.adapters.in.commandhandler;

import com.example.cqrs.domain.bus.Command;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddDataCommand extends Command {

	private String id;
	private String value;

}
