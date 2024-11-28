package com.jaimes.calculadora.app.controller;

import com.jaimes.calculadora.app.entity.Figura2D;
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

    //Constructor de los servicios en el controlador
    @Autowired
    public HistorialController(Figura2DService figura2dService, Figura3DService figura3dService, JdbcTemplate jdbcTemplate){
        this.figura2DService = figura2dService;
        this.figura3DService = figura3dService;
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/historial")
    public String listarElemento(Model model){
        //Variable para enviar Query a MySQL
        String sql = "SHOW TABLES";
        Integer id = 2123;
        //Almacenar los elementos en una lista
        List<String> tablas = jdbcTemplate.queryForList(sql, String.class);
        //Mostrar la lista en el modelo
        model.addAttribute("listaTablas", tablas);
        //Ir a la vista HTML
        return "shistorial";
    }

    @GetMapping("/historial/{elemento}")
    public String listaFigura(Model model){
        List<Figura3D> figura3d = figura3DService.obtenerTodas3d();
        List<Figura2D> figura2d = figura2DService.obtenerTodas2d();
        model.addAttribute("elemento3d", figura3d);
        model.addAttribute("elemento2d", figura2d);
        return "historial";
    }

    //Eliminar Figuras3d en el historial
    @GetMapping("/eliminar/figura3d/{id}")
    public String eliminarFigura3d(@PathVariable Integer id){
        //Elimina la figura por el ID
        figura3DService.eliminarFigura3d(id);
        //Retorna al historial de las figuras3D
        return "redirect:/historial/figura3d";
    }

    //Eliminar Figura2d en el historial
    @GetMapping("/eliminar/figura2d/{id}")
    public String  eliminarFigura2d(@PathVariable Integer id){
        //Elimina la figura por el ID
        figura2DService.eliminarFigura2d(id);
        //Retorna al historial de las figuras2D
        return "redirect:/historial/figura2d";
    }

    //Ir a la pagina para modificar Figura3d
    @GetMapping("editar/figura3d/{id}")
    public String ModificarFigura3d(@PathVariable Integer id, Model model) {
        //Se obtiene el elemento atravez del ID para remapearlo en el HTML
        Figura3D figura = figura3DService.obtenerFigura3d(id);
        //Mapeo de atributos para la vista
        Map<String, Object> atributos = new HashMap<>();
        atributos.put("operacion", "Editar " + figura.getElemento());
        atributos.put("nombre", figura.getTipo());
        atributos.put("tipo", figura.getTipo());
        atributos.put("largo", figura.getLargo());
        atributos.put("ancho", figura.getAncho());
        atributos.put("alto", figura.getAlto());
        atributos.put("cantidad", figura.getCantidad());
        model.addAllAttributes(atributos);
        //Envia el ID por URL para actualizar el elemento en la DDBB
        model.addAttribute("accion", "/figura3d/" + id);
        //Llama al HTML cubico
        return "cubico";
    }

    @GetMapping("editar/figura2d/{id}")
    public String ModificarFigura2d(@PathVariable Integer id, Model model){
        //Se obtiene el elemento atravez del ID para remapearlo en el HTML
        Figura2D figura = figura2DService.obtenerFigura2d(id);
        //Mapeo de atributos para la vista
        Map<String, Object> atributos = new HashMap<>();
        atributos.put("operacion", "Editar " + figura.getElemento());
        atributos.put("nombre", figura.getTipo());
        atributos.put("tipo", figura.getTipo());
        atributos.put("largo", figura.getLargo());
        atributos.put("ancho", figura.getAncho());
        atributos.put("cantidad", figura.getCantidad());
        model.addAllAttributes(atributos);
        //Envia el ID por URL para actualizar el elemento en la DDBB
        model.addAttribute("accion", "/figura2d/" + id);
        return "cuadrado";
    }

    //Actualizar una figura existente
    @PostMapping("figura3d/{id}")
    public String ActualizarFigura3d(@PathVariable Integer id, @ModelAttribute Figura3D figura) {
        //Se recalcula las medidas para guardar en la DDBB
        figura.calcular();
        //Actualiza el elemento atravez del ID, y se pasa la nueva figura
        figura3DService.actualizarFigura3d(id, figura);
        //Se redirige a la pagina Historial
        return "redirect:/historial/figura3d";
    }

    @PostMapping("figura2d/{id}")
    public String ActualizarFigura2d(@PathVariable Integer id, @ModelAttribute Figura2D figura) {
        //Se recalcula las medidas para guardar en la DDBB
        figura.calcular();
        //Actualiza el elemento atravez del ID, y se pasa la nueva figura
        figura2DService.actualizarFigura2d(id, figura);
        //Se redirige a la pagina Historial
        return "redirect:/historial/figura2d";
    }
}
