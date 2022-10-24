package com.example.cqrs.infrastructure.adapters.in.commandbus;

import com.example.cqrs.domain.bus.Command;
import com.example.cqrs.domain.bus.CommandBusHandler;
import com.example.cqrs.domain.ports.bus.CommandBus;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Primary
public class CommandBusImpl implements CommandBus {

	private Map<Class, CommandBusHandler> handlers;

	public CommandBusImpl(List<CommandBusHandler> commandHandlerImplementations) {
		this.handlers = new HashMap<>();
		commandHandlerImplementations.forEach(commandHandler -> {
			Class<?> commandClass = getCommandClass(commandHandler);
			handlers.put(commandClass, commandHandler);
		});
	}

	@Override
	public void handle(Command command) throws Exception {
		if (!handlers.containsKey(command.getClass())) {
			throw new Exception(String.format("No handler for %s", command.getClass().getName()));
		}
		handlers.get(command.getClass()).handle(command);
	}

	private Class<?> getCommandClass(CommandBusHandler handler) {
		Type commandInterface = ((ParameterizedType) handler.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
		return getClass(commandInterface.getTypeName());
	}

	private Class<?> getClass(String name) {
		try {
			return Class.forName(name);
		}
		catch (Exception e) {
			return null;
		}
	}
}