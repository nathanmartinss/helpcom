package com.helpcom.api.Ingrediente;

public record IngredienteDTO(Long idItem, Integer qtdIngrediente, UnidadeMedida unidadeMedida) {
    public IngredienteDTO(Ingrediente ingrediente) {
        this(ingrediente.getIdItem(), ingrediente.getQtdIngrediente(), ingrediente.getUnidadeMedida());
    }
}
