package com.example.cqrs.domain.ports.bus.commandbus;

import com.example.cqrs.domain.bus.Command;

public interface CommandHandler<T extends Command> {

    void handle(T command) throws Exception;
}