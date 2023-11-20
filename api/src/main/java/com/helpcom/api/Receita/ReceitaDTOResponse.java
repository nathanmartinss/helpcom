package com.helpcom.api.Receita;

import com.helpcom.api.Ingrediente.IngredienteDTO;

import java.util.List;

public record ReceitaDTOResponse(Long id, String nomeReceita, String descReceita, String prepReceita, List<IngredienteDTO> ingredientes) {
}
