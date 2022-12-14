package com.example.cqrs.application.add;

import com.example.cqrs.domain.bus.Command;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddDataCommandDto extends Command {

	private String id;
	private String value;

}
