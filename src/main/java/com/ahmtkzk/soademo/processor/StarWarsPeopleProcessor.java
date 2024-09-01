package com.ahmtkzk.soademo.processor;

import com.ahmtkzk.soademo.model.starwars.StarWarsPeopleResponseEntity;
import com.ahmtkzk.soademo.repository.StarWarsRepository;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class StarWarsPeopleProcessor implements Processor {

    private final StarWarsRepository repository;

    public StarWarsPeopleProcessor(StarWarsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        StarWarsPeopleResponseEntity entity = (StarWarsPeopleResponseEntity) exchange.getMessage().getBody();
        repository.save(entity);
    }

}
