package com.bootcamp.prueba;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


public interface MessageService {

    public String getMessage();

}
