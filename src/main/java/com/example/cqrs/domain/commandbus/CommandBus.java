package com.example.cqrs.domain.commandbus;

public interface CommandBus {

    void handle(Command command) throws Exception;
}