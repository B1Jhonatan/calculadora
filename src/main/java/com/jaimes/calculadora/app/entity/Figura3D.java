package com.jaimes.calculadora.app.entity;

import com.jaimes.calculadora.app.entity.interfaces.Calcular;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Figura3D implements Calcular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String elemento;
    private String tipo;
    private Double largo;
    private Double ancho;
    private Double alto;
    private Integer cantidad;
    private Double areaUnidad;
    private Double areaTotal;

    @Override
    public void calcular() {

        double resultado;

        resultado = largo * ancho * alto;
        setAreaUnidad(resultado);

        resultado = largo * ancho * alto * cantidad;
        setAreaTotal(resultado);

    }

}