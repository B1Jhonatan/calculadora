package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.entity.Figura2D;
import com.jaimes.calculadora.app.entity.Figura3D;
import com.jaimes.calculadora.app.services.implement.CuadradoService;
import com.jaimes.calculadora.app.services.implement.Figura3DService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedidasController {

    @Autowired
    private Figura3DService figura3DService;

    @Autowired
    private CuadradoService cuadradoService;

    String nombre;
    String operacion;

    //Guardar la figura en la DDBB
    @PostMapping("/cuadrado")
    public String Cuadrado(@ModelAttribute Figura2D medidas, Model model) {
        cuadradoService.crearCuadrado(medidas);
        model.addAttribute("accion", "/cuadrado");
        return "cuadrado";   
    }

    //Guardar la figura en la DDBB
    @PostMapping({"/zapatas", "/pedestales", "/vigas", "/columnas"})
    public String Cubico(HttpServletRequest request, @ModelAttribute Figura3D medidas, Model model) {
        //Guarda los datos puestos en el formulario del HTML
        figura3DService.crearFigura(medidas);
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