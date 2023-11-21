package com.helpcom.api.Ingrediente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "ingredientes")
@Entity(name = "ingrediente")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idItem;
    private Long idReceita;
    private Integer qtdIngrediente;
    private UnidadeMedida unidadeMedida;

    public Ingrediente (IngredienteDTO dados, Long idReceita) {
        this.idItem = dados.idItem();
        this.idReceita = idReceita;
        this.qtdIngrediente = dados.qtdIngrediente();
        this.unidadeMedida = dados.unidadeMedida();
    }
}
