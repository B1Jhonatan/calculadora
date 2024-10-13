package com.jaimes.calculadora.app.models.interfaces;

import com.jaimes.calculadora.app.models.Figura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiguraRepository extends JpaRepository <Figura, Integer> {
}
