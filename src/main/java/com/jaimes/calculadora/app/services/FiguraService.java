package com.jaimes.calculadora.app.services;

import com.jaimes.calculadora.app.entity.Figura;
import com.jaimes.calculadora.app.repository.FiguraRepository;
import com.jaimes.calculadora.app.services.implement.IFiguraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiguraService implements IFiguraService {

    @Autowired
    private FiguraRepository figuraRepository;

    @Override
    public List<Figura> obtenerTodas() {
        return figuraRepository.findAll();
    }

    @Override
    public Figura obtenerPorId(Integer id) {
        return figuraRepository.findById(id).orElse(null);
    }

    @Override
    public Figura crearFigura(Figura figura) {
        return figuraRepository.save(figura);
    }

    @Override
    public Figura actualizarFigura(Integer id, Figura figura) {
        Figura figuraDB = figuraRepository.findById(id).orElse(null);

        if(figuraDB != null){

            figuraDB.setLargo(figura.getLargo());
            figuraDB.setAncho(figura.getAncho());
            figuraDB.setAlto(figura.getAlto());
            figuraDB.setCantidad(figura.getCantidad());
            figuraDB.setResultado(figura.getResultado());
            return figuraRepository.save(figuraDB);

        }

        return null;
    }

    @Override
    public void eliminarPersona(Integer id) {
        figuraRepository.deleteById(id);
    }
}
