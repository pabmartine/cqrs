package com.example.cqrs.application.data;

import com.example.cqrs.domain.commandbus.CommandHandler;
import com.example.cqrs.domain.model.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddDataCommandHandler implements CommandHandler<AddDataCommand> {

    @Autowired
    private DataService dataService;

    @Override
    public void handle(AddDataCommand command) throws Exception {
        dataService.add(command.getData());
    }
}