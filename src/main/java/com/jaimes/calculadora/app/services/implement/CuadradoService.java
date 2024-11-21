package com.jaimes.calculadora.app.services.implement;

import com.jaimes.calculadora.app.entity.Cuadrado;

import java.util.List;

public interface CuadradoService {

    List<Cuadrado> obtenerTodas();

    Cuadrado obtenerPorId(Integer id);

    Cuadrado crearCuadrado(Cuadrado cuadrado);

    Cuadrado actualizarCuadrado(Integer id, Cuadrado cuadrado);

    void eliminarCuadrado(Integer id);

}
