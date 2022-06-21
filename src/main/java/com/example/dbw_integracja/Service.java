package com.example.dbw_integracja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@org.springframework.stereotype.Service
public class Service {
    private final Repository repo;

    @Autowired
    public Service(Repository repo
    ) {
        this.repo = repo;
    }
    WebClient dziedziny = WebClient.create("https://api-dbw.stat.gov.pl/api/1.1.0/area/area-area");
    WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = dziedziny.post();
  WebClient.RequestBodySpec bodySpec = uriSpec.uri("/resource");
    WebClient.RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue("data");
    Mono<String> response = headersSpec.retrieve().bodyToMono(String.class);


    public Mono<String> getResponse() {
        return response;
    }
}
