package com.bootcamp.prueba;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class MessageServiceImp implements MessageService{

    @Value("${course.message}")
    private String message;


    @Override

    public String getMessage() {
        return this.message;
    }
}
