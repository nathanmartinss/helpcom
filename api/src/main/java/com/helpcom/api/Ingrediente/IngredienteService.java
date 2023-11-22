package com.helpcom.api.Ingrediente;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredienteService {

    public static IngredienteDTO converterParaDTO(Ingrediente ingrediente) {
        return new IngredienteDTO(
                ingrediente.getIdItem(),
                ingrediente.getQtdIngrediente(),
                ingrediente.getUnidadeMedida()
        );
    }
    public static List<IngredienteDTO> converterListaParaDTO(List<Ingrediente> ingredientes) {
        return ingredientes.stream()
                .map(IngredienteService::converterParaDTO)
                .collect(Collectors.toList());
    }
}
