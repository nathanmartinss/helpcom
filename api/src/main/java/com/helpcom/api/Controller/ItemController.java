package com.helpcom.api.Controller;

import com.helpcom.api.Item.Item;
import com.helpcom.api.Item.ItemDTO;
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
    public void adicionarItem(@RequestBody ItemDTO dados) {
        repository.save(new Item(dados));
    }

    @GetMapping
    public List<ItemDTO> listarItems () {
        return repository.findAll().stream().map(ItemDTO :: new).toList();
    }
}
