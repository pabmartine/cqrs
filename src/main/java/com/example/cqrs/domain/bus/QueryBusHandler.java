package com.example.cqrs.domain.bus;

import com.example.cqrs.domain.bus.Query;

public interface QueryBusHandler<T,U extends Query<T>> {

    T handle(U query) throws Exception;
}