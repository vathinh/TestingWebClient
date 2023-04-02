package org.webclientTest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.webclientTest.dto.Testing;
import org.webclientTest.service.WebClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientServiceImpl implements WebClientService {
    @Autowired
    WebClient webClient;

    @Override
    public Flux<Testing> getAll() {
        return webClient.get()
                .uri("/todos")
                .retrieve()
                .bodyToFlux(Testing.class);
    }

    @Override
    public Mono<Testing> getById(Integer id) {
        return webClient.get()
                .uri("/todos/" + id)
                .retrieve()
                .bodyToMono(Testing.class);
    }

    @Override
    public Mono<Testing> create(Testing test) {
        return webClient.post()
                .uri("/todos")
                .body(Mono.just(test), Testing.class)
                .retrieve()
                .bodyToMono(Testing.class);
    }
}
