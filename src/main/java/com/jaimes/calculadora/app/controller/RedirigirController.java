package com.jaimes.calculadora.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RedirigirController {

    private String operacion = "Area";
    private String nombre;

    @GetMapping({"/zapatas", "/pedestales", "/vigas", "/columnas"})
    public String cubico(HttpServletRequest request, Model model){
        //Variables para moldear el HTML a el uso que se le va a dar
        nombre = request.getRequestURI();
        //Mapeo del HTML para el uso que se le va a dar a "cubico"
        model.addAttribute("operacion", operacion);
        model.addAttribute("nombre", nombre.substring(1));
        return "cubico";
    }

    @GetMapping({"/pisos", "/estuco"})
    public String cuadrado(HttpServletRequest request, Model model){
        //Variables para moldear el HTML a el uso que se le va a dar
        nombre = request.getRequestURI();
        //Mapeo del HTML para el uso que se le va a dar a "cuadrado"
        model.addAttribute("operacion", operacion);
        model.addAttribute("nombre", nombre.substring(1));
        return "cuadrado";
    }

}
