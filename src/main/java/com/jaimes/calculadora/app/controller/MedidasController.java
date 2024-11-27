package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.entity.Figura2D;
import com.jaimes.calculadora.app.entity.Figura3D;
import com.jaimes.calculadora.app.services.Figura2DService;
import com.jaimes.calculadora.app.services.Figura3DService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedidasController {

    private final Figura3DService figura3DService;
    private final Figura2DService figura2DService;
    
    @Autowired
    public MedidasController(Figura2DService figura2dService, Figura3DService figura3dService){
        this.figura2DService = figura2dService;
        this.figura3DService = figura3dService;
    }

    private String nombre;
    private String operacion;

    //Guardar la figura en la DDBB
    @PostMapping("/cuadrado")
    public String Cuadrado(@ModelAttribute Figura2D medidas, Model model) {
        figura2DService.crearFigura2d(medidas);
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