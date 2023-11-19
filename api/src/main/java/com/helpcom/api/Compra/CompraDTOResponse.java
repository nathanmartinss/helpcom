package com.helpcom.api.Compra;

import com.helpcom.api.Item.Item;

import java.util.Date;

public record CompraDTOResponse(Long id, Long idItem, Integer qtdItem, Integer valor, Date validade, Date dataCompra) {
    public CompraDTOResponse(Compra compra) {
        this(compra.getId(), compra.getIdItem(), compra.getQtdItem(), compra.getValor(), compra.getValidade(), compra.getDataCompra());
    }
}