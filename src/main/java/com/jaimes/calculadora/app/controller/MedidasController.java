package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.models.Figura;
import com.jaimes.calculadora.app.repository.FiguraRepository;
import com.jaimes.calculadora.app.services.implement.FiguraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedidasController {

    @Autowired
    private FiguraRepository figuraRepository;

    @Autowired
    private FiguraService figuraService;

    // GET: Mostrar formulario de cálculo cúbico
    @GetMapping("/cubico")
    public String cubicoController(Model model) {
        // Se pasa una nueva instancia de Figura para el formulario
        model.addAttribute("medidas", new Figura());
        model.addAttribute("accion", "/cubico");
        return "cubico";
    }

    // GET: Mostrar formulario de cálculo cuadrado
    @GetMapping("/cuadrado")
    public String cuadradoController(Model model) {
        model.addAttribute("medidas", new Figura());
        return "cuadrado";
    }

    // POST: Procesar formulario para figura cuadrada
    @PostMapping("/cuadrado")
    public String Cuadrado(@ModelAttribute Figura medidas, Model model) {
        double resultado = medidas.calcular();

        // Guarda la figura
        figuraService.crearFigura(medidas);

        // Añadir el resultado al modelo
        model.addAttribute("resultado", resultado);
        model.addAttribute("accion", "/cuadrado");
        return "cuadrado";
    }

    // POST: Procesar formulario para figura cúbica
    @PostMapping("/cubico")
    public String Cubico(@ModelAttribute Figura medidas, Model model) {
        double resultado = medidas.calcular();
        // Guarda la figura
        figuraService.crearFigura(medidas);
        // Añadir el resultado al modelo
        model.addAttribute("resultado", resultado);
        model.addAttribute("accion", "/cubico");
        return "cubico";
    }

}