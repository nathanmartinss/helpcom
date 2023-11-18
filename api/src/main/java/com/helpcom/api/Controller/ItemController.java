package com.helpcom.api.Controller;

import com.helpcom.api.Item.Item;
import com.helpcom.api.Item.ItemDTORequest;
import com.helpcom.api.Item.ItemDTOResponse;
import com.helpcom.api.Item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemRepository repository;
    @PostMapping
    @Transactional
    public void adicionarItem(@RequestBody ItemDTORequest dados) {
        repository.save(new Item(dados));
    }

    @GetMapping
    public List<ItemDTOResponse> listarItems() {
        return repository.findAll().stream().map(ItemDTOResponse:: new).toList();
    }

    @PutMapping
    @Transactional
    public void alterarItem(@RequestBody ItemDTOResponse dados) {
        var item = repository.getReferenceById(dados.id());
        item.atualizarInfo(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirItem(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
