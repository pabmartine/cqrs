package com.example.cqrs.infrastructure.adapters.in.querybus;

import com.example.cqrs.domain.bus.Query;
import com.example.cqrs.domain.bus.QueryBusHandler;
import com.example.cqrs.domain.ports.bus.QueryBus;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Primary
public class QueryBusImpl implements QueryBus {

	private Map<Class, QueryBusHandler> handlers;

	public QueryBusImpl(List<QueryBusHandler> queryHandlerImplementations) {
		this.handlers = new HashMap<>();
		queryHandlerImplementations.forEach(queryHandler -> {
			Class queryClass = getQueryClass(queryHandler);
			handlers.put(queryClass, queryHandler);
		});
	}

	@Override
	public <T> T handle(Query<T> query) throws Exception {
		if (!handlers.containsKey(query.getClass())) {
			throw new Exception(String.format("No handler for %s", query.getClass().getName()));
		}
		return (T) handlers.get(query.getClass()).handle(query);
	}

	private Class<?> getQueryClass(QueryBusHandler handler) {
		Type commandInterface = ((ParameterizedType) handler.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[1];
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