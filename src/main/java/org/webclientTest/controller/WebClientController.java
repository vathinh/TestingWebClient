package org.webclientTest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.webclientTest.dto.Testing;
import org.webclientTest.service.WebClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/webclient")
@RequiredArgsConstructor
public class WebClientController {
    @Autowired
    private final WebClientService webClientService;

    @GetMapping
    public Flux<Testing> getAll(){
        return webClientService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Testing> findById(@PathVariable("id") Integer id) {
        return webClientService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Testing> create(@RequestBody Testing testing) {
        return webClientService.create(testing);
    }



}
