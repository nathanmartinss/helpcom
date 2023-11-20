package com.helpcom.api.Compra;


import java.time.LocalDate;

public record CompraDTORequest(Long idItem, Integer qtdItem, Integer valor, LocalDate validade, LocalDate dataCompra) {
    public CompraDTORequest(Compra compra) {
        this(compra.getIdItem(), compra.getQtdItem(), compra.getValor(), compra.getValidade(), compra.getDataCompra());
    }
}
