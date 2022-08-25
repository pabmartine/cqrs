package com.example.cqrs.domain.ports.bus.querybus;

import com.example.cqrs.domain.bus.Query;

public interface QueryHandler<T,U extends Query<T>> {

    T handle(U query) throws Exception;
}