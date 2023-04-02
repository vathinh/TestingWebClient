package org.webclientTest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.webclientTest.dto.Testing;
import reactor.core.publisher.Flux;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient getWebClient()
    {
        return WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
