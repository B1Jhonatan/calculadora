package com.jaimes.calculadora.app.models;

import com.jaimes.calculadora.app.models.interfaces.Calcular;
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
public class Figura implements Calcular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private Double largo;
    private Double ancho;
    private Double alto;
    private Integer cantidad;
    private Double resultado;

    @Override
    public double calcular() {

        double resultado;

        if (cantidad == 0) {
            resultado = largo * ancho * alto;
        } else {
            resultado = largo * ancho * alto * cantidad;
        }

        setResultado(resultado);

        return resultado;

    }

}