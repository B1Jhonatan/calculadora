package com.jaimes.calculadora.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaimes.calculadora.app.entity.Figura2D;

@Repository
public interface Figura2DRepository extends JpaRepository<Figura2D, Integer> {
}
