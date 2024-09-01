package com.ahmtkzk.soademo.controller;

import com.ahmtkzk.soademo.model.placeholder.PlaceholderPostResponseEntity;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/placeholder")
public class PlaceholderController {

    private final ProducerTemplate template;

    public PlaceholderController(ProducerTemplate template) {
        this.template = template;
    }

    @GetMapping("/post/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlaceholderPostResponseEntity getPostById(@PathVariable int id) {
        return template.requestBodyAndHeader("direct:placeholder-posts-id", null, "id", id, PlaceholderPostResponseEntity.class);
    }

}
