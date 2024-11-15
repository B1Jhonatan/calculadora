package com.jaimes.calculadora.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RedirigirController {

    @GetMapping({"/zapatas", "/pedestales", "/vigas", "/columnas"})
    public String cubico(HttpServletRequest request, Model model){
        String ruta = request.getRequestURI().substring(1);
        model.addAttribute("nombre", ruta);
        return "cubico";
    }

    @GetMapping({"/pisos", "/estuco"})
    public String cuadrado(){
        return "cuadrado";
    }

}
