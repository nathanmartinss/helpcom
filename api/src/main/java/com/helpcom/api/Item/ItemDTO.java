package com.helpcom.api.Item;

public record ItemDTO(String descItem, String marcaItem) {
    public ItemDTO (Item item) {
        this(item.getDescItem(), item.getMarcaItem());
    }
}
