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

    public Figura Medidas(double largo, double ancho) {

        this.largo = largo;
        this.ancho = ancho;
        this.resultado = calcular();
        return this;

    }

    public Figura Medidas(double largo, double ancho, double alto) {

        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.resultado = calcular();
        return this;

    }

    public Figura Medidas(double largo, double ancho, int cantidad) {

        this.largo = largo;
        this.ancho = ancho;
        this.cantidad = cantidad;
        this.resultado = calcular();
        return this;

    }

    public Figura Medidas(double largo, double ancho, double alto, int cantidad) {

        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.cantidad = cantidad;
        this.resultado = calcular();
        return this;

    }

    @Override
    public double calcular() {

        if (alto == 0 && cantidad == 0) {
            return largo * ancho;
        }
        else if (cantidad == 0) {
            return largo * ancho * alto;
        }
        else if (alto == 0) {
            return largo * ancho * cantidad;
        } else {
            return largo * ancho * alto * cantidad;
        }

    }
}