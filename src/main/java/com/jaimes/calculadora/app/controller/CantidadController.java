package com.jaimes.calculadora.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jaimes.calculadora.app.services.Figura3DService;
import com.jaimes.calculadora.app.services.implement.clases.Cantidades;


@Controller
public class CantidadController {
    
    private final Figura3DService figura3dService;

    @Autowired
    public CantidadController(Figura3DService figura3dService){
        this.figura3dService = figura3dService;
    }

    @GetMapping("/cantidades")
    public String Cantidades(Model model){

        List<Cantidades> elementos = figura3dService.cantidades3d();
        model.addAttribute("cantidades", elementos);

        return "cantidades";
    }

}
