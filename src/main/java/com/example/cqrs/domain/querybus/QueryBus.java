package com.example.cqrs.domain.querybus;

public interface QueryBus {

	<T> T handle(Query<T> query) throws Exception;
}