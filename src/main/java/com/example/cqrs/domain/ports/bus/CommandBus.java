package com.example.cqrs.domain.ports.bus;

import com.example.cqrs.domain.bus.Command;

public interface CommandBus {

    void handle(Command command) throws Exception;
}