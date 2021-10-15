package com.restapi.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.demo.domain.Message;
import org.springframework.asm.TypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/breeds")
public class MessageController {

    @GetMapping("list/all")
    public ResponseEntity<Message> getAll()
    {
        Map<String, List<String>> data = readData();
        if(data!=null) {
            Message message = new Message();
            message.setMessage(data);
            message.setStatus("success");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_EXTENDED);
    }
    private Map<String, List<String>> readData()
    {
        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = TypeReference.class.getResourceAsStream("/jsondata/data.json");

        try {
            return objectMapper.readValue(inputStream, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
