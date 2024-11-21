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

    String nombre;
    String operacion;

    //Guardar la figura en la DDBB
    @PostMapping("/cuadrado")
    public String Cuadrado(@ModelAttribute Cuadrado medidas, Model model) {
        cuadradoService.crearCuadrado(medidas);
        model.addAttribute("accion", "/cuadrado");
        return "cuadrado";   
    }

    //Guardar la figura en la DDBB
    @PostMapping({"/zapatas", "/pedestales", "/vigas", "/columnas"})
    public String Cubico(HttpServletRequest request, @ModelAttribute Figura medidas, Model model) {
        //Guarda los datos puestos en el formulario del HTML
        figuraService.crearFigura(medidas);
        operacion = "Area";
        nombre = request.getRequestURI();
        model.addAttribute("operacion", operacion);
        model.addAttribute("nombre", nombre.substring(1));
        //Retorna la pagina despues de guardar los elementos enviados
        model.addAttribute("accion", nombre);
        //Devuelve el HTML cubico
        return "cubico";
    }
    
}