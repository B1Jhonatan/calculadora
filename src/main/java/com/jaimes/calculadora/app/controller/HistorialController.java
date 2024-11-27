package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.entity.Figura3D;
import com.jaimes.calculadora.app.services.Figura2DService;
import com.jaimes.calculadora.app.services.Figura3DService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HistorialController {

    private final Figura3DService figura3DService;
    private final Figura2DService figura2DService;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HistorialController(Figura2DService figura2dService, Figura3DService figura3dService, JdbcTemplate jdbcTemplate){
        this.figura2DService = figura2dService;
        this.figura3DService = figura3dService;
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/historial2")
    public String listarElemento(Model model){
        String sql = "SHOW TABLES";
        List<String> tablas = jdbcTemplate.queryForList(sql, String.class);
        model.addAttribute("listaElementos", tablas);
        return "shistorial";
    }

    @GetMapping("/historial")
    public String listaFigura(Model model){
        List<Figura3D> figuras = figura3DService.obtenerTodas3d();
        model.addAttribute("listaFiguras", figuras);
        return "historial";
    }

    //Eliminar Figuras en el historial
    @GetMapping("/eliminar/elemento/{id}")
    public String eliminarFigura(@PathVariable Integer id){
        figura3DService.eliminarFigura3d(id);
        return "redirect:/historial";
    }

    //Ir a la pagina para modificar Figura
    @GetMapping("editar/elemento/{id}")
    public String ModificarFigura(@PathVariable Integer id, @ModelAttribute Figura3D figura, Model model) {
        //Se obtiene el elemento atravez del ID para remapearlo en el HTML
        Figura3D elemento = figura3DService.obtenerFigura3d(id);
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
        figura3DService.actualizarFigura3d(id, figura);
        //Se redirige a la pagina Historial
        return "redirect:/historial";
    }
}
