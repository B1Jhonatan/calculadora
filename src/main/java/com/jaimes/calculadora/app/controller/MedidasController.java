package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.entity.Cuadrado;
import com.jaimes.calculadora.app.entity.Figura;
import com.jaimes.calculadora.app.services.implement.ICuadradoService;
import com.jaimes.calculadora.app.services.implement.IFiguraService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedidasController {

    @Autowired
    private IFiguraService figuraService;

    @Autowired
    private ICuadradoService cuadradoService;

    String ruta;
    Double resultado;

    //Guardar la figura en la DDBB
    @PostMapping("/cuadrado")
    public String Cuadrado(@ModelAttribute Cuadrado medidas, Model model) {
        resultado = medidas.calcular();

        cuadradoService.crearCuadrado(medidas);

        model.addAttribute("resultado", resultado);
        model.addAttribute("accion", "/cuadrado");
        return "cuadrado";
    }

    //Guardar la figura en la DDBB
    @PostMapping({"/cubico", "/zapatas", "/pedestales", "/vigas", "/columnas"})
    public String Cubico(HttpServletRequest request, @ModelAttribute Figura medidas, Model model) {
        resultado = medidas.calcular();
        ruta = request.getRequestURI().substring(1);

        figuraService.crearFigura(medidas);

        model.addAttribute("nombre", ruta);
        model.addAttribute("resultado", resultado);
        model.addAttribute("accion", "/cubico");
        return "cubico";
    }

}