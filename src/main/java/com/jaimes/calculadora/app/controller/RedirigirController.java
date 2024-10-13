package com.jaimes.calculadora.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RedirigirController {

    @PostMapping("/redirigir")
    public String Redirigir(String accion){

        switch (accion){
            case "cuadrado":
                return "redirect:/cuadrado";
            case "cubico":
                return "redirect:/cubico";
            case "historial":
                return "redirect:/historial";
            default:
                return "redirect:/";
        }
    }

}
