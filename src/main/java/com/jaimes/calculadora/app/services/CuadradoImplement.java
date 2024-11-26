package com.jaimes.calculadora.app.services;

import com.jaimes.calculadora.app.entity.Figura2D;
import com.jaimes.calculadora.app.repository.CuadradoRepository;
import com.jaimes.calculadora.app.services.implement.CuadradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuadradoImplement implements CuadradoService {

    @Autowired
    private CuadradoRepository cuadradoRepository;

    @Override
    public List<Figura2D> obtenerTodas() {
        return cuadradoRepository.findAll();
    }

    @Override
    public Figura2D obtenerPorId(Integer id) {
        return cuadradoRepository.findById(id).orElse(null);
    }

    @Override
    public Figura2D crearCuadrado(Figura2D cuadrado) {
        return cuadradoRepository.save(cuadrado);
    }

    @Override
    public Figura2D actualizarCuadrado(Integer id, Figura2D cuadrado) {
        Figura2D cuadradoDB = cuadradoRepository.findById(id).orElse(null);

        if(cuadradoDB != null){

            cuadradoDB.setLargo(cuadrado.getLargo());
            cuadradoDB.setAncho(cuadrado.getAncho());
            cuadradoDB.setCantidad(cuadrado.getCantidad());
            cuadradoDB.setResultado(cuadrado.getResultado());
            return cuadradoRepository.save(cuadradoDB);

        }

        return null;

    }

    @Override
    public void eliminarCuadrado(Integer id) {
        cuadradoRepository.deleteById(id);
    }
}
