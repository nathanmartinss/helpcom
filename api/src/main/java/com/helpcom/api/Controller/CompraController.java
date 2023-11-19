package com.helpcom.api.Controller;

import com.helpcom.api.Compra.Compra;
import com.helpcom.api.Compra.CompraDTORequest;
import com.helpcom.api.Compra.CompraDTOResponse;
import com.helpcom.api.Compra.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compra")
public class CompraController {

    @Autowired
    private CompraRepository repository;
    @PostMapping
    @Transactional
    public void adicionarCompra(@RequestBody CompraDTORequest dados) {
        repository.save(new Compra(dados));
    }
    @GetMapping("/{idItem}")
    public List<CompraDTOResponse> listarCompras(@PathVariable Long idItem) {
        return repository.findAllByIdItem(idItem).stream().map(CompraDTOResponse:: new).toList();
    }
    @PutMapping
    @Transactional
    public void alterarCompra(@RequestBody CompraDTOResponse dados) {
        var compra = repository.getReferenceById(dados.id());
        compra.atualizarInfo(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluirCompra(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
