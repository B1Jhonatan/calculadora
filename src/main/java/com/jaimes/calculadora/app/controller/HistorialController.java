package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.entity.Figura;
import com.jaimes.calculadora.app.services.implement.CuadradoService;
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

    @Autowired
    CuadradoService cuadradoService;


    @GetMapping("/historial")
    public String listaFiguras(String tipo, Model model){
        List<Figura> figuras = figuraService.obtenerTodas();
        model.addAttribute("listaFiguras", figuras);
        return "historial";
    }

    //Eliminar Figuras en el historial
    @GetMapping("/historial/eliminar/{id}")
    public String eliminarFigura(@PathVariable Integer id){
        figuraService.eliminarPersona(id);
        return "redirect:/historial";
    }

    //Ir a la pagina para modificar Figura
    @GetMapping("editar/elemento/{id}")
    public String ModificarFigura(@PathVariable Integer id, @ModelAttribute Figura figura, Model model) {
        //Se obtiene el elemento atravez del ID para remapearlo en el HTML
        Figura elemento = figuraService.obtenerPorId(id);
        //Remapeo de la operacion que se va a realizar
        model.addAttribute("operacion", "Editar " + elemento.getElemento());
        model.addAttribute("nombre", elemento.getTipo());
        //Remapeo de los valores del elemento
        model.addAttribute("tipo", elemento.getTipo());
        model.addAttribute("largo", elemento.getLargo());
        model.addAttribute("ancho", elemento.getAncho());
        model.addAttribute("alto", elemento.getAlto());
        model.addAttribute("cantidad", elemento.getCantidad());
        //Envia el ID por URL para actualizar el elemento en la DDBB
        model.addAttribute("accion", "/" + id);
        //Llama al HTML cubico
        return "cubico";
    }

    //Actualizar una figura existente
    @PostMapping("/{id}")
    public String ActualizarFigura(@PathVariable Integer id, @ModelAttribute Figura figura) {
        //Se recalcula las medidas para guardar en la DDBB
        figura.calcular();
        //Actualiza el elemento atravez del ID, y se pasa la nueva figura
        figuraService.actualizarFigura(id, figura);
        //Se redirige a la pagina Historial
        return "redirect:/historial";
    }
}
