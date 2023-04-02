package org.webclientTest.service;
import org.webclientTest.dto.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WebClientService {
     Flux<Testing> getAll();
     Mono<Testing> getById(Integer id);
     Mono<Testing> create(Testing test);



}
