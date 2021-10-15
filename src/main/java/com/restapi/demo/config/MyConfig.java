package com.restapi.demo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder)
    {
        return builder.build();
    }
}
