package com.example.cqrs.application.data;

import com.example.cqrs.domain.commandbus.CommandHandler;
import com.example.cqrs.domain.model.WriteDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddDataCommandHandler implements CommandHandler<AddDataCommand> {

    @Autowired
    private WriteDataService writeDataService;

    @Override
    public void handle(AddDataCommand command) throws Exception {
        writeDataService.add(command.getData());
    }
}