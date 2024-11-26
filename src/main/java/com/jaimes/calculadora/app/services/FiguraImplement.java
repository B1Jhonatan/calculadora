package com.jaimes.calculadora.app.services;

import com.jaimes.calculadora.app.entity.Figura3D;
import com.jaimes.calculadora.app.repository.FiguraRepository;
import com.jaimes.calculadora.app.services.implement.Figura3DService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiguraImplement implements Figura3DService {

    @Autowired
    private FiguraRepository figuraRepository;

    @Override
    public List<Figura3D> obtenerTodas() {
        return figuraRepository.findAll();
    }

    @Override
    public Figura3D obtenerPorId(Integer id) {
        return figuraRepository.findById(id).orElse(null);
    }

    @Override
    public Figura3D crearFigura(Figura3D figura) {
        figura.calcular();
        return figuraRepository.save(figura);
    }

    @Override
    public Figura3D actualizarFigura(Integer id, Figura3D figura) {
        Figura3D figuraDB = figuraRepository.findById(id).orElse(null);
        if(figuraDB != null){
            figuraDB.setTipo(figura.getTipo());
            figuraDB.setLargo(figura.getLargo());
            figuraDB.setAncho(figura.getAncho());
            figuraDB.setAlto(figura.getAlto());
            figuraDB.setCantidad(figura.getCantidad());
            figuraDB.setAreaUnidad(figura.getAreaUnidad());
            figuraDB.setAreaTotal(figura.getAreaTotal());
            return figuraRepository.save(figuraDB);
        }
        return null;
    }

    @Override
    public void eliminarPersona(Integer id) {
        figuraRepository.deleteById(id);
    }
}
