package com.helpcom.api.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table (name = "items")
@Entity (name = "item")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descItem;
    private String marcaItem;

    public Item(ItemDTO dados) {
        this.descItem = dados.descItem();
        this.marcaItem = dados.marcaItem();
    }
}
