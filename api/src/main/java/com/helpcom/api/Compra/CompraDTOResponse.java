package com.helpcom.api.Compra;


import java.time.LocalDate;

public record CompraDTOResponse(Long id, Long idItem, Integer qtdItem, Integer valor, LocalDate validade, LocalDate dataCompra) {
    public CompraDTOResponse(Compra compra) {
        this(compra.getId(), compra.getIdItem(), compra.getQtdItem(), compra.getValor(), compra.getValidade(), compra.getDataCompra());
    }
}