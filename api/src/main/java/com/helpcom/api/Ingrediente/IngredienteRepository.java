package com.helpcom.api.Ingrediente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredienteRepository extends JpaRepository <Ingrediente, Long>{
    List<Ingrediente> findByIdReceita(Long idReceita);

    void deleteByIdReceita(Long idReceita);
}
