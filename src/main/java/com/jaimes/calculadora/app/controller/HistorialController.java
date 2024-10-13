package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.models.Figura;
import com.jaimes.calculadora.app.services.implement.FiguraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HistorialController {

    @Autowired
    FiguraService figuraService;


    @GetMapping("/historial")
    public String listaFiguras(Model model){
        List<Figura> figuras = figuraService.obtenerTodas();
        model.addAttribute("listaFiguras", figuras);
        return "historial";
    }
}
