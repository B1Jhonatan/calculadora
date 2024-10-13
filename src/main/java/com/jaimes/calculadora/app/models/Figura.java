package com.jaimes.calculadora.app.models;

import com.jaimes.calculadora.app.models.interfaces.ICalcular;
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
public class Figura implements ICalcular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private double largo;
    private double ancho;
    private double alto;
    private int cantidad;
    private double resultado;

    @Override
    public double calcular() {

        double resultado;

        if (alto == 0 && cantidad == 0) {
            resultado = largo * ancho;
        }
        else if (cantidad == 0) {
            resultado = largo * ancho * alto;
        }
        else if (alto == 0) {
            resultado = largo * ancho * cantidad;
        } else {
            resultado = largo * ancho * alto * cantidad;
        }

        setResultado(resultado);

        return resultado;
    }
}