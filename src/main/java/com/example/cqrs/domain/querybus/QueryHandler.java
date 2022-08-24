package com.example.cqrs.domain.querybus;

public interface QueryHandler<T,U extends Query<T>> {

    T handle(U query) throws Exception;
}