package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.entity.Figura3D;
import com.jaimes.calculadora.app.services.implement.CuadradoService;
import com.jaimes.calculadora.app.services.implement.Figura3DService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HistorialController {

    @Autowired
    Figura3DService figura3DService;

    @Autowired
    CuadradoService cuadradoService;


    @GetMapping("/historial")
    public String listaFiguras(String tipo, Model model){
        List<Figura3D> figuras = figura3DService.obtenerTodas();
        model.addAttribute("listaFiguras", figuras);
        return "historial";
    }

    //Eliminar Figuras en el historial
    @GetMapping("/historial/eliminar/{id}")
    public String eliminarFigura(@PathVariable Integer id){
        figura3DService.eliminarPersona(id);
        return "redirect:/historial";
    }

    //Ir a la pagina para modificar Figura
    @GetMapping("editar/elemento/{id}")
    public String ModificarFigura(@PathVariable Integer id, @ModelAttribute Figura3D figura, Model model) {
        //Se obtiene el elemento atravez del ID para remapearlo en el HTML
        Figura3D elemento = figura3DService.obtenerPorId(id);
        //Mapeo de atributos para la vista
        Map<String, Object> atributos = new HashMap<>();
        atributos.put("operacion", "Editar " + elemento.getElemento());
        atributos.put("nombre", elemento.getTipo());
        atributos.put("tipo", elemento.getTipo());
        atributos.put("largo", elemento.getLargo());
        atributos.put("ancho", elemento.getAncho());
        atributos.put("alto", elemento.getAlto());
        atributos.put("cantidad", elemento.getCantidad());
        model.addAllAttributes(atributos);
        //Envia el ID por URL para actualizar el elemento en la DDBB
        model.addAttribute("accion", "/" + id);
        //Llama al HTML cubico
        return "cubico";
    }

    //Actualizar una figura existente
    @PostMapping("/{id}")
    public String ActualizarFigura(@PathVariable Integer id, @ModelAttribute Figura3D figura) {
        //Se recalcula las medidas para guardar en la DDBB
        figura.calcular();
        //Actualiza el elemento atravez del ID, y se pasa la nueva figura
        figura3DService.actualizarFigura(id, figura);
        //Se redirige a la pagina Historial
        return "redirect:/historial";
    }
}
