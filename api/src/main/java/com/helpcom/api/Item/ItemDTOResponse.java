package com.helpcom.api.Item;

public record ItemDTOResponse(Long id, String descItem, String marcaItem) {
    public ItemDTOResponse(Item item) {
        this(item.getId(), item.getDescItem(), item.getMarcaItem());
    }
}
