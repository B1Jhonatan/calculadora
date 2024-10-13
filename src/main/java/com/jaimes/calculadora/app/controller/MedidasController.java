package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.models.Figura;
import com.jaimes.calculadora.app.models.interfaces.FiguraRepository;
import com.jaimes.calculadora.app.services.implement.FiguraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedidasController {

    @Autowired
    FiguraRepository figuraRepository;

    @Autowired
    FiguraService figuraService;

    Figura figura = new Figura();

    @GetMapping("/cubico")
    public String cubicoController(){
        return "cubico";
    }

    @GetMapping("/cuadrado")
    public String cuadradoController(){
        return "cuadrado";
    }

    @PostMapping("/cuadrado")
    public String Cuadrado(double largo, double ancho, int cantidad, Model model){

        double resultado;
        figura.Medidas(largo, ancho, cantidad);

        figuraService.crearFigura(figura);

        resultado = figura.calcular();
        model.addAttribute("resultado", resultado);

        return "cuadrado";
    }

    @PostMapping("/cubico")
    public String Cubico(double largo, double ancho, double alto, int cantidad, Model model){

        double resultado;
        figura.Medidas(largo, ancho, alto, cantidad);

        figuraService.crearFigura(figura);

        resultado = figura.calcular();
        model.addAttribute("resultado", resultado);

        return "cubico";
    }
}
