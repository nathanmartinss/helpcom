package com.helpcom.api.Compra;

import com.helpcom.api.Item.Item;

import java.util.Date;

public record CompraDTORequest(Long idItem, Integer qtdItem, Integer valor, Date validade, Date dataCompra) {
    public CompraDTORequest(Compra compra) {
        this(compra.getIdItem(), compra.getQtdItem(), compra.getValor(), compra.getValidade(), compra.getDataCompra());
    }
}
