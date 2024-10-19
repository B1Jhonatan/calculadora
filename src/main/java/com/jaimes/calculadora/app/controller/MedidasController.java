package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.models.Cuadrado;
import com.jaimes.calculadora.app.models.Figura;
import com.jaimes.calculadora.app.services.implement.ICuadradoService;
import com.jaimes.calculadora.app.services.implement.IFiguraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedidasController {

    @Autowired
    private IFiguraService figuraService;

    @Autowired
    private ICuadradoService cuadradoService;

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
        model.addAttribute("medidas", new Cuadrado());
        return "cuadrado";
    }

    //Guardar la figura en la DDBB
    @PostMapping("/cuadrado")
    public String Cuadrado(@ModelAttribute Cuadrado medidas, Model model) {
        double resultado = medidas.calcular();

        cuadradoService.crearCuadrado(medidas);

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