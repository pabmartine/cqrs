package com.example.cqrs.application.data;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.model.DataRepository;
import com.example.cqrs.domain.querybus.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetDataQueryHandler implements QueryHandler<Data,GetDataQuery> {

    @Autowired
    private DataRepository dataRepository;

    @Override
    public Data handle(GetDataQuery query) throws Exception {
        return dataRepository.findById(query.getId()).orElse(null);
    }
}