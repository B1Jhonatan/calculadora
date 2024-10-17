package com.jaimes.calculadora.app.services.implement;

import com.jaimes.calculadora.app.models.Figura;

import java.util.List;

public interface FiguraService {

    List<Figura> obtenerTodas();

    Figura obtenerPorId(Integer id);

    Figura crearFigura(Figura figura);

    Figura actualizarFigura(Integer id, Figura figura);

    void eliminarPersona(Integer id);

}