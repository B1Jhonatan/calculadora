package com.jaimes.calculadora.app.entity;

import com.jaimes.calculadora.app.entity.interfaces.Calcular;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Figura2D implements Calcular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String elemento;
    private String tipo;
    private Double largo;
    private Double ancho;
    private Integer cantidad;
    private Double areaUnidad;
    private Double areaTotal;

    @Override
    public void calcular() {

        double resultado;

        resultado = largo * ancho;
        resultado = Math.round(resultado * 100.0) / 100.0;
        setAreaUnidad(resultado);

        resultado = largo * ancho * cantidad;
        resultado = Math.round(resultado * 100.0) / 100.0;
        setAreaTotal(resultado);

    }
}
