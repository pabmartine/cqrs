package com.example.cqrs.domain.ports.bus.commandbus;

import com.example.cqrs.domain.bus.Command;

public interface CommandBus {

    void handle(Command command) throws Exception;
}