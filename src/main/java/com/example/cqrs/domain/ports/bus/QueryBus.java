package com.example.cqrs.domain.ports.bus;

import com.example.cqrs.domain.bus.Query;

public interface QueryBus {

	<T> T handle(Query<T> query) throws Exception;
}