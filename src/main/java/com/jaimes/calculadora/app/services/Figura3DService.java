package com.jaimes.calculadora.app.services;

import java.util.List;

import com.jaimes.calculadora.app.entity.Figura3D;
import com.jaimes.calculadora.app.services.implement.clases.Cantidades;

public interface Figura3DService {

    //Creacion de los servicios de la API
    List<Figura3D> obtenerTodas3d();
    Figura3D obtenerFigura3d(Integer id);
    Figura3D crearFigura3d(Figura3D figura);
    Figura3D actualizarFigura3d(Integer id, Figura3D figura);
    void eliminarFigura3d(Integer id);
    List<Cantidades> cantidades3d();

}
