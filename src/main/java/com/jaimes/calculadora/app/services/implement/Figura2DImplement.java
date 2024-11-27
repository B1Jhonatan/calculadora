package com.jaimes.calculadora.app.services.implement;

import com.jaimes.calculadora.app.entity.Figura2D;
import com.jaimes.calculadora.app.repository.Figura2DRepository;
import com.jaimes.calculadora.app.services.Figura2DService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Figura2DImplement implements Figura2DService {

    @Autowired
    private Figura2DRepository figura2dRepository;

    @Override
    public List<Figura2D> obtenerTodas2d() {
        return figura2dRepository.findAll();
    }

    @Override
    public Figura2D obtenerFigura2d(Integer id) {
        return figura2dRepository.findById(id).orElse(null);
    }

    @Override
    public Figura2D crearFigura2d(Figura2D figura) {
        figura.calcular();
        return figura2dRepository.save(figura);
    }

    @Override
    public Figura2D actualizarFigura2d(Integer id, Figura2D figura) {
        Figura2D figura2d = figura2dRepository.findById(id).orElse(null);

        if(figura2d != null){

            figura2d.setTipo(figura.getTipo());
            figura2d.setLargo(figura.getLargo());
            figura2d.setAncho(figura.getAncho());
            figura2d.setCantidad(figura.getCantidad());
            figura2d.setAreaUnidad(figura.getAreaUnidad());
            figura2d.setAreaTotal(figura.getAreaTotal());

            return figura2dRepository.save(figura2d);

        }

        return null;

    }

    @Override
    public void eliminarFigura2d(Integer id) {
        figura2dRepository.deleteById(id);
    }
}
