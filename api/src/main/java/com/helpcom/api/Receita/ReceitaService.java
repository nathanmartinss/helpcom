package com.helpcom.api.Receita;

import com.helpcom.api.Ingrediente.IngredienteDTO;
import com.helpcom.api.Ingrediente.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceitaService {

    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public ReceitaService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public ReceitaDTOResponse mapToDTO(Receita receita) {
        List<IngredienteDTO> ingredientes = ingredienteRepository.findByIdReceita(receita.getId())
                .stream()
                .map(IngredienteDTO::new)
                .collect(Collectors.toList());

        return new ReceitaDTOResponse(
                receita.getId(),
                receita.getNomeReceita(),
                receita.getDescReceita(),
                receita.getPrepReceita(),
                ingredientes
        );
    }
}
