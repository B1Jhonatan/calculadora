package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.models.Figura;
import com.jaimes.calculadora.app.services.implement.FiguraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HistorialController {

    @Autowired
    FiguraService figuraService;

    @GetMapping("/historial")
    public String listaFiguras(Model model){
        List<Figura> figuras = figuraService.obtenerTodas();
        model.addAttribute("listaFiguras", figuras);
        return "historial";
    }

    @GetMapping("/historial/eliminar/{id}")
    public String eliminarFigura(@PathVariable Integer id){
        figuraService.eliminarPersona(id);
        return "redirect:/historial";
    }

    @GetMapping("cubico/editar/{id}")
    public String ModificarFigura(@PathVariable Integer id, @ModelAttribute Figura figura, Model model) {
        model.addAttribute("medidas", figura);
        model.addAttribute("accion", "/historial/editar/" + id);
        return "editarcubico";
    }


    // POST: Actualizar una figura existente
    @PostMapping("/historial/editar/{id}")
    public String ActualizarFigura(@PathVariable Integer id, @ModelAttribute Figura figura) {
        // Actualiza la figura en la base de datos
        figura.calcular();
        figuraService.actualizarFigura(id, figura);
        return "redirect:/historial";  // Redirigir a la página principal después de la edición
    }

}
