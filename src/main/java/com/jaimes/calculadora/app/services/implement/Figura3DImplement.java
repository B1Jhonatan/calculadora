package com.jaimes.calculadora.app.services.implement;

import com.jaimes.calculadora.app.entity.Figura3D;
import com.jaimes.calculadora.app.repository.Figura3DRepository;
import com.jaimes.calculadora.app.services.Figura3DService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Figura3DImplement implements Figura3DService {

    @Autowired
    private Figura3DRepository figura3dRepository;

    @Override
    public List<Figura3D> obtenerTodas3d() {
        return figura3dRepository.findAll();
    }

    @Override
    public Figura3D obtenerFigura3d(Integer id) {
        return figura3dRepository.findById(id).orElse(null);
    }

    @Override
    public Figura3D crearFigura3d(Figura3D figura) {
        figura.calcular();
        return figura3dRepository.save(figura);
    }

    @Override
    public Figura3D actualizarFigura3d(Integer id, Figura3D figura) {
        Figura3D figura3d = figura3dRepository.findById(id).orElse(null);

        if(figura3d != null){

            figura3d.setTipo(figura.getTipo());
            figura3d.setLargo(figura.getLargo());
            figura3d.setAncho(figura.getAncho());
            figura3d.setAlto(figura.getAlto());
            figura3d.setCantidad(figura.getCantidad());
            figura3d.setAreaUnidad(figura.getAreaUnidad());
            figura3d.setAreaTotal(figura.getAreaTotal());

            return figura3dRepository.save(figura3d);

        }

        return null;
        
    }

    @Override
    public void eliminarFigura3d(Integer id) {
        figura3dRepository.deleteById(id);
    }
}
