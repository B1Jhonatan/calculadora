package com.jaimes.calculadora.app.repository;

import com.jaimes.calculadora.app.entity.Figura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiguraRepository extends JpaRepository <Figura, Integer> {
}
