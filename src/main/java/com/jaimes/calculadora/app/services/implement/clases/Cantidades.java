package com.jaimes.calculadora.app.services.implement.clases;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cantidades {

    private double cemento;
    private double arena;
    private double triturado;
    private double area;

    public Cantidades(){
        
    }
    public Cantidades(double area){
        this.area = area;
    }

    public void cantidades(){
        cemento = Math.round(area * 420.0 * 100.00) / 100.00;
        arena = Math.round(area * 0.67 * 100.00) / 100.00;
        triturado = Math.round(area * 0.67 * 100.00) / 100.00;
    }
    
}
