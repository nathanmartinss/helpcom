package com.helpcom.api.Receita;

import com.helpcom.api.Ingrediente.IngredienteDTO;

import java.util.List;

public record ReceitaDTOResponse(Long id, String nomeReceita, String descReceita, String prepReceita, List<IngredienteDTO> ingredientes) {
    public ReceitaDTOResponse (Receita receita, List<IngredienteDTO> ingredientes) {this(receita.getId(), receita.getNomeReceita(), receita.getDescReceita(), receita.getPrepReceita(), ingredientes);}
}
