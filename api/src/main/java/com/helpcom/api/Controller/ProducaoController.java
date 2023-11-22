package com.helpcom.api.Controller;

import com.helpcom.api.Producao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("producao")
public class ProducaoController {

    @Autowired
    private ProducaoRepository repository;

    @Autowired
    private ProducaoService service;
    @PostMapping
    @Transactional
    public void adicionarProducao(@RequestBody ProducaoDTORequest dados) {
        Long valor = service.calcularCusto(dados.idReceita());
        if (service.verificarQuantidade(dados.idReceita())) {
            service.atualizarQuantidades(dados.idReceita());
            repository.save(new Producao(dados, valor));
        }
    }

    @GetMapping
    public List<ProducaoDTOResponse> listarProducoes() {
        return repository.findAll().stream().map(ProducaoDTOResponse:: new).toList();
    }

    @GetMapping("/{id}")
    public ProducaoDTOResponse listarProducaoPorId(@PathVariable Long id) {
        Producao producao = repository.getReferenceById(id);
        return new ProducaoDTOResponse(producao);
    }

    @PutMapping
    @Transactional
    public void alterarProducao (@RequestBody ProducaoDTOUpdate dados) {
        var producao = repository.getReferenceById(dados.getId());
        producao.atualizarInfo(dados);
    }

    @DeleteMapping ("/{id}")
    @Transactional
    public void deletarProducao (@PathVariable Long id) {
        repository.deleteById(id);
    }

}
