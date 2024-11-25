package com.jaimes.calculadora.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaimes.calculadora.app.entity.cubico.Figura3D;

@Repository
public interface FiguraRepository extends JpaRepository <Figura3D, Integer> {
}
