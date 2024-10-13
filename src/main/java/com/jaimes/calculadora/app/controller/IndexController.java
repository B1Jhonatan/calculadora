package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.models.Figura;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String indexController(){
        return "index";
    }

}
