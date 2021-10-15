package com.restapi.demo.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Message {
    String status;
    Map<String, List<String>> message;

    public Message(String status, Map<String, List<String>> message) {
        this.status = status;
        this.message = message;
    }

    public Message(){}

    public String getStatus() {
        return status;
    }

    public Map<String, List<String>> getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(Map<String, List<String>> message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return Objects.equals(status, message1.status) && Objects.equals(message, message1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }
}
