package com.jaimes.calculadora.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RedirigirController {

    String operacion;
    String ruta;

    @GetMapping({"/zapatas", "/pedestales", "/vigas", "/columnas"})
    public String cubico(HttpServletRequest request, Model model){

        operacion = "Area";
        ruta = request.getRequestURI().substring(1);
        
        model.addAttribute("operacion", operacion);
        model.addAttribute("nombre", ruta);
        return "cubico";
    }

    @GetMapping({"/pisos", "/estuco"})
    public String cuadrado(){
        return "cuadrado";
    }

}
