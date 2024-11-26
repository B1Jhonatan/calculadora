package com.jaimes.calculadora.app.services.implement;

import java.util.List;

import com.jaimes.calculadora.app.entity.Figura3D;

public interface Figura3DService {

    List<Figura3D> obtenerTodas();

    Figura3D obtenerPorId(Integer id);

    Figura3D crearFigura(Figura3D figura);

    Figura3D actualizarFigura(Integer id, Figura3D figura);

    void eliminarPersona(Integer id);

}
