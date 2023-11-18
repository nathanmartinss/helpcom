package com.helpcom.api.Item;

public record ItemDTORequest(String descItem, String marcaItem) {
    public ItemDTORequest(Item item) {
        this(item.getDescItem(), item.getMarcaItem());
    }
}
