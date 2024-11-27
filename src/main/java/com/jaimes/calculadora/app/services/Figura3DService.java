package com.jaimes.calculadora.app.services;

import java.util.List;

import com.jaimes.calculadora.app.entity.Figura3D;

public interface Figura3DService {

    List<Figura3D> obtenerTodas3d();

    Figura3D obtenerFigura3d(Integer id);

    Figura3D crearFigura3d(Figura3D figura);

    Figura3D actualizarFigura3d(Integer id, Figura3D figura);

    void eliminarFigura3d(Integer id);

}
