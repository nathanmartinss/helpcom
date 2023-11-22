package com.helpcom.api.Controller;

import com.helpcom.api.Ingrediente.Ingrediente;
import com.helpcom.api.Ingrediente.IngredienteDTO;
import com.helpcom.api.Ingrediente.IngredienteRepository;
import com.helpcom.api.Ingrediente.IngredienteService;
import com.helpcom.api.Receita.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("receita")
public class ReceitaController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Autowired
    private ReceitaService receitaService;

    @Autowired
    private IngredienteService ingredienteService;

    @PostMapping
    @Transactional
    public void adicionarReceita(@RequestBody ReceitaDTORequest dados) {
        Receita receita = (Receita) receitaRepository.save(new Receita(dados));

        for (IngredienteDTO ingredienteDTO : dados.ingredientes()) {
            Ingrediente ingrediente = new Ingrediente (ingredienteDTO, receita.getId());

            ingredienteRepository.save(ingrediente);
        }
    }
    @GetMapping
    public List<ReceitaDTOResponse> listarReceitas() {
        List<Receita> receitas = receitaRepository.findAll();
        return receitas.stream()
                .map(receitaService::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReceitaDTOResponse listarReceitaPorId (@PathVariable Long id) {
        Receita receita = receitaRepository.getReferenceById(id);
        List<Ingrediente> ingredientes = ingredienteRepository.findByIdReceita(id);

        List<IngredienteDTO> ingredienteDTOS = IngredienteService.converterListaParaDTO(ingredientes);
        return new ReceitaDTOResponse(receita, ingredienteDTOS);
    }

    @PutMapping
    @Transactional
    public void alterarReceita(@RequestBody ReceitaDTOResponse dados) {
        var receita = receitaRepository.getReferenceById(dados.id());
        receita.atualizarInfo(dados);

        ingredienteRepository.deleteByIdReceita(dados.id());
        for (IngredienteDTO ingredienteDTO : dados.ingredientes()) {
            Ingrediente ingrediente = new Ingrediente(ingredienteDTO, dados.id());
            ingredienteRepository.save(ingrediente);
        }
    }
    @DeleteMapping ("/{id}")
    @Transactional
    public void deletarReceita(@PathVariable Long id) {
        ingredienteRepository.deleteByIdReceita(id);
        receitaRepository.deleteById(id);
    }
}
