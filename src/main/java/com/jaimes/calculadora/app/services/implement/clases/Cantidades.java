package com.jaimes.calculadora.app.services.implement.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

        cemento = area * 420;
        arena = area * 0.67;
        triturado = area * 0.67;

    }
    
}
