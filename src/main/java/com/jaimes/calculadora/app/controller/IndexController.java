package com.jaimes.calculadora.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String indexController(){
        return "index";
    }
    
}
