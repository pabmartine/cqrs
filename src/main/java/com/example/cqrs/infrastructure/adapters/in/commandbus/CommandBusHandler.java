package com.example.cqrs.infrastructure.adapters.in.commandbus;

import com.example.cqrs.domain.bus.Command;

public interface CommandBusHandler<T extends Command> {

    void handle(T command) throws Exception;
}