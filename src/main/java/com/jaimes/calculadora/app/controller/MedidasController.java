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
    
    //Constructor de los servicios dentro del controllador
    @Autowired
    public MedidasController(Figura2DService figura2dService, Figura3DService figura3dService){
        this.figura2DService = figura2dService;
        this.figura3DService = figura3dService;
    }

    //Variables para usar en el mapeo del HTML
    private String nombre;
    private String operacion = "Area";

    //Guardar la figura en la DDBB
    @PostMapping({"/estuco", "/pisos"})
    public String Cuadrado(HttpServletRequest request, @ModelAttribute Figura2D medidas, Model model) {
        //Guarda los datos puestos en el formulario del HTML
        figura2DService.crearFigura2d(medidas);
        //Variables para moldear el HTML a el uso que se le va a dar
        nombre = request.getRequestURI();
        model.addAttribute("operacion", operacion);
        model.addAttribute("nombre", nombre);
        //Retorna la pagina despues de guardar los elementos enviados
        model.addAttribute("accion", nombre);
        //Vuelve a cargar el formulario
        return "cuadrado";   
    }

    //Guardar la figura en la DDBB
    @PostMapping({"/zapatas", "/pedestales", "/vigas", "/columnas"})
    public String Cubico(HttpServletRequest request, @ModelAttribute Figura3D medidas, Model model) {
        //Guarda los datos puestos en el formulario del HTML
        figura3DService.crearFigura3d(medidas);
        //Variables para moldear el HTML a el uso que se le va a dar
        nombre = request.getRequestURI();
        model.addAttribute("operacion", operacion);
        model.addAttribute("nombre", nombre.substring(1));
        //Retorna la pagina despues de guardar los elementos enviados
        model.addAttribute("accion", nombre);
        //Devuelve el HTML cubico
        return "cubico";
    }
    
}