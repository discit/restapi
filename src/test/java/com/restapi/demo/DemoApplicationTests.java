package com.restapi.demo;

import com.google.gson.Gson;
import com.restapi.demo.domain.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    Gson gson;
    @Test
    void contextLoads() {
    }

    @Test
    void readDataTest()
    {

        String data = "{\"message\":{\"wolfhound\":[\"irish\"],\"newfoundland\":[]}, \"status\":\"success\"}";
        Message expectMessage = gson.fromJson(data, Message.class);

        Message message = restTemplate.getForObject("http://localhost:8080/api/breeds/list/all", Message.class);
        boolean ret = expectMessage.equals(message);
        Assert.isTrue(ret, "success!");
    }
}
