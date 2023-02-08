package com.bootcamp.prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

    private MessageService messageService;
    @Autowired
    public MessageRestController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/api/v1/message")
    public String getMessage(){
        return this.messageService.getMessage();
    };




}
