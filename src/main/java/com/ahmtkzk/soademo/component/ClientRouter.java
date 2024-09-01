package com.ahmtkzk.soademo.component;

import com.ahmtkzk.soademo.model.placeholder.PlaceholderPostResponseEntity;
import com.ahmtkzk.soademo.model.starwars.StarWarsPeopleResponseEntity;
import com.ahmtkzk.soademo.processor.StarWarsPeopleProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ClientRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Placeholder /posts/{id}
        from("direct:placeholder-posts-id")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .toD("https://jsonplaceholder.typicode.com/posts/${header.id}")
                .unmarshal()
                .json(PlaceholderPostResponseEntity.class)
                .log("Placeholder GET /posts/${header.id}, response body: ${body}")
                .end();

        // StarWars /people/{id}
        from("direct:starwars-people-id")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .toD("https://swapi.dev/api/people/${header.id}")
                .unmarshal()
                .json(StarWarsPeopleResponseEntity.class)
                .log("StarWars GET /people/${header.id}, response body: ${body}")
                //.process(new StarWarsPeopleProcessor())
                .bean(StarWarsPeopleProcessor.class)
                .end();
    }

}
