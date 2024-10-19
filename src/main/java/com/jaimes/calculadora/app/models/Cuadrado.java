package com.jaimes.calculadora.app.models;

import com.jaimes.calculadora.app.models.interfaces.Calcular;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cuadrado implements Calcular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private Double largo;
    private Double ancho;
    private Integer cantidad;
    private Double resultado;

    @Override
    public double calcular() {

        double resultado;

        if (cantidad == 0) {
            resultado = largo * ancho;
        } else {
            resultado = largo * ancho * cantidad;
        }

        setResultado(resultado);

        return resultado;

    }
}
