package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.models.Figura;
import com.jaimes.calculadora.app.repository.FiguraRepository;
import com.jaimes.calculadora.app.services.implement.FiguraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedidasController {

    @Autowired
    private FiguraRepository figuraRepository;

    @Autowired
    private FiguraService figuraService;

    //Mostrar pagina para crear figuras
    @GetMapping("/cubico")
    public String cubicoController(Model model) {
        model.addAttribute("medidas", new Figura());
        model.addAttribute("accion", "/cubico");
        return "cubico";
    }

    //Mostrar pagina para crear figuras
    @GetMapping("/cuadrado")
    public String cuadradoController(Model model) {
        model.addAttribute("medidas", new Figura());
        return "cuadrado";
    }

    //Guardar la figura en la DDBB
    @PostMapping("/cuadrado")
    public String Cuadrado(@ModelAttribute Figura medidas, Model model) {
        double resultado = medidas.calcular();

        figuraService.crearFigura(medidas);

        model.addAttribute("resultado", resultado);
        model.addAttribute("accion", "/cuadrado");
        return "cuadrado";
    }

    //Guardar la figura en la DDBB
    @PostMapping("/cubico")
    public String Cubico(@ModelAttribute Figura medidas, Model model) {
        double resultado = medidas.calcular();

        figuraService.crearFigura(medidas);

        model.addAttribute("resultado", resultado);
        model.addAttribute("accion", "/cubico");
        return "cubico";
    }

}