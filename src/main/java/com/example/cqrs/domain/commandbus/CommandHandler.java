package com.example.cqrs.domain.commandbus;

public interface CommandHandler<T extends Command> {

    void handle(T command) throws Exception;
}