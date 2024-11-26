package com.jaimes.calculadora.app.services.implement;

import java.util.List;

import com.jaimes.calculadora.app.entity.Figura2D;

public interface CuadradoService {

    List<Figura2D> obtenerTodas();

    Figura2D obtenerPorId(Integer id);

    Figura2D crearCuadrado(Figura2D cuadrado);

    Figura2D actualizarCuadrado(Integer id, Figura2D cuadrado);

    void eliminarCuadrado(Integer id);

}
