package com.example.cqrs.infrastructure.adapters.in.commandbus;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.ports.usecase.AddCommandDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddDataCommandHandler implements CommandBusHandler<AddDataCommandDto> {

    @Autowired
    private AddCommandDataUseCase commandDataUseCase;

    @Override
    public void handle(AddDataCommandDto addDataCommand) throws Exception {
        commandDataUseCase.add(Data.builder().id(addDataCommand.getId()).value(addDataCommand.getValue()).build());
    }
}