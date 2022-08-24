package com.example.cqrs.application.data;

import com.example.cqrs.domain.model.Data;
import com.example.cqrs.domain.model.DataCreated;
import com.example.cqrs.domain.model.ReadDataRepository;
import com.example.cqrs.domain.model.WriteDataRepository;
import com.example.cqrs.domain.querybus.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GetDataQueryHandler implements QueryHandler<DataCreated,GetDataQuery> {

    @Autowired
    private ReadDataRepository readDataRepository;

    @Override
    public DataCreated handle(GetDataQuery query) throws Exception {
        return readDataRepository.findById(query.getId()).orElse(null);
    }
}