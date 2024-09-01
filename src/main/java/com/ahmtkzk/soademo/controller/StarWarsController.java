package com.ahmtkzk.soademo.controller;

import com.ahmtkzk.soademo.model.starwars.StarWarsPeopleResponseEntity;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    private final ProducerTemplate template;

    public StarWarsController(ProducerTemplate template) {
        this.template = template;
    }

    @GetMapping("/people/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StarWarsPeopleResponseEntity getPeopleById(@PathVariable int id) {
        return template.requestBodyAndHeader("direct:starwars-people-id", null, "id", id, StarWarsPeopleResponseEntity.class);
    }

}
