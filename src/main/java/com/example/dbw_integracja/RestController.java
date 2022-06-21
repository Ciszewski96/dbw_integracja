package com.example.dbw_integracja;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private static final Logger log = LoggerFactory.getLogger(RestController.class);


    private final Service service;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    public RestController(
            Service service
    ) {
        this.service = service;
    }

    @RequestMapping("/")
    public String getHomepage() {
        return "show";
    }

    @GetMapping("/1")
    public String firstRequestFromRestService() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        var result = restTemplate.exchange("https://api-dbw.stat.gov.pl/api/1.1.0/area/area-area", HttpMethod.GET, entity, String.class).getBody();
        log.info(result);
        return result;
    }




}
