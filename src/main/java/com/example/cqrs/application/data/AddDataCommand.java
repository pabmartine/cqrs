package com.example.cqrs.application.data;

import com.example.cqrs.domain.commandbus.Command;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddDataCommand extends Command {

	private com.example.cqrs.domain.model.Data data;

}
