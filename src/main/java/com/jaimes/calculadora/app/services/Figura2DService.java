package com.jaimes.calculadora.app.services;

import java.util.List;

import com.jaimes.calculadora.app.entity.Figura2D;

public interface Figura2DService {

    //Creacion de los servicios de la API
    List<Figura2D> obtenerTodas2d();
    Figura2D obtenerFigura2d(Integer id);
    Figura2D crearFigura2d(Figura2D figura);
    Figura2D actualizarFigura2d(Integer id, Figura2D figura);
    void eliminarFigura2d(Integer id);

}
