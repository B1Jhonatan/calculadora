package com.jaimes.calculadora.app.services.implement;

import com.jaimes.calculadora.app.entity.Figura3D;
import com.jaimes.calculadora.app.repository.Figura3DRepository;
import com.jaimes.calculadora.app.services.Figura3DService;
import com.jaimes.calculadora.app.services.implement.clases.Cantidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Figura3DImplement implements Figura3DService {

    private final Figura3DRepository figura3dRepository;

    @Autowired
    private Figura3DImplement(Figura3DRepository figura3dRepository){
        this.figura3dRepository = figura3dRepository;
    }

    //Obtener todas las figuras3D
    @Override
    public List<Figura3D> obtenerTodas3d() {
        return figura3dRepository.findAll();
    }

    //Obtener una figuras3D por medio del id
    @Override
    public Figura3D obtenerFigura3d(Integer id) {
        return figura3dRepository.findById(id).orElse(null);
    }

    //Crear una figura3D
    @Override
    public Figura3D crearFigura3d(Figura3D figura) {
        figura.calcular();
        return figura3dRepository.save(figura);
    }

    //Actualizar una figura3D
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

    //Eliminar una figura3D por medio del id
    @Override
    public void eliminarFigura3d(Integer id) {
        figura3dRepository.deleteById(id);
    }

    @Override
    public List<Cantidades> cantidades3d() {

        List<Figura3D> elementos = figura3dRepository.findAll();
        List<Cantidades> areas = new ArrayList<>();

        for(Figura3D elemento: elementos){
            double areaUnidad = elemento.getAreaUnidad();
            double areaTotal = elemento.getAreaTotal();
            Cantidades cantidades1 = new Cantidades(areaUnidad);
            Cantidades cantidades2 = new Cantidades(areaTotal);
            cantidades1.cantidades();
            cantidades2.cantidades();
            areas.add(cantidades1);
            areas.add(cantidades2);
        }

        return areas;

    }
}
