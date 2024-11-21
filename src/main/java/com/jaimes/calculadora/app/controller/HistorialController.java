package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.entity.Figura;
import com.jaimes.calculadora.app.services.implement.ICuadradoService;
import com.jaimes.calculadora.app.services.implement.IFiguraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HistorialController {

    @Autowired
    IFiguraService figuraService;

    @Autowired
    ICuadradoService cuadradoService;


    @GetMapping("/historial")
    public String listaFiguras(String tipo, Model model){

        List<Figura> figuras = figuraService.obtenerTodas();

        model.addAttribute("listaFiguras", figuras);

        return "historial";

    }

    // Eliminar Figuras en el historial
    @GetMapping("/historial/eliminar/{id}")
    public String eliminarFigura(@PathVariable Integer id){
        figuraService.eliminarPersona(id);
        return "redirect:/historial";
    }

    // Ir a la pagina para modificar Figura
    @GetMapping("editar/elemento/{id}")
    public String ModificarFigura(@PathVariable Integer id, @ModelAttribute Figura figura, Model model) {

        Figura elemento = figuraService.obtenerPorId(id);

        model.addAttribute("operacion", "Editar " + elemento.getElemento());
        model.addAttribute("nombre", elemento.getTipo());
        model.addAttribute("tipo", elemento.getTipo());
        model.addAttribute("largo", elemento.getLargo());
        model.addAttribute("ancho", elemento.getAncho());
        model.addAttribute("alto", elemento.getAlto());
        model.addAttribute("cantidad", elemento.getCantidad());
        model.addAttribute("accion", "/" + id);

        return "cubico";
        
    }


    // Actualizar una figura existente
    @PostMapping("/{id}")
    public String ActualizarFigura(@PathVariable Integer id, @ModelAttribute Figura figura) {

        figura.calcular();

        figuraService.actualizarFigura(id, figura);
        return "redirect:/historial";
    }

}
