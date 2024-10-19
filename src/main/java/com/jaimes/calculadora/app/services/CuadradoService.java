package com.jaimes.calculadora.app.services;

import com.jaimes.calculadora.app.models.Cuadrado;
import com.jaimes.calculadora.app.repository.CuadradoRepository;
import com.jaimes.calculadora.app.services.implement.ICuadradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuadradoService implements ICuadradoService {

    @Autowired
    private CuadradoRepository cuadradoRepository;

    @Override
    public List<Cuadrado> obtenerTodas() {
        return cuadradoRepository.findAll();
    }

    @Override
    public Cuadrado obtenerPorId(Integer id) {
        return cuadradoRepository.findById(id).orElse(null);
    }

    @Override
    public Cuadrado crearCuadrado(Cuadrado cuadrado) {
        return cuadradoRepository.save(cuadrado);
    }

    @Override
    public Cuadrado actualizarCuadrado(Integer id, Cuadrado cuadrado) {
        Cuadrado cuadradoDB = cuadradoRepository.findById(id).orElse(null);

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
