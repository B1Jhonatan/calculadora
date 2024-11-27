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
    public double calcular() {

        double resultado;

        resultado = largo * ancho;
        setAreaUnidad(resultado);

        resultado = largo * ancho * cantidad;
        setAreaTotal(resultado);

        return resultado;

    }
}
