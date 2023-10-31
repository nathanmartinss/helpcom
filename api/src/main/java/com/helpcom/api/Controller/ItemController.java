package com.helpcom.api.Controller;

import com.helpcom.api.Item.NovoItemDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
public class ItemController {
    @PostMapping
    public void adicionarItem(@RequestBody NovoItemDTO dados) {
        System.out.println(dados);

    }
}
