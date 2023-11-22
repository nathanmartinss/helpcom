package com.helpcom.api.Compra;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "Compras")
@Entity(name = "Compra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idItem;
    private Integer qtdItem;
    private Integer valor;
    private LocalDate validade;
    private LocalDate dataCompra;

    public Compra(CompraDTORequest dados) {
        this.idItem = dados.idItem();
        this.qtdItem = dados.qtdItem();
        this.valor = dados.valor();
        this.validade = dados.validade();
        this.dataCompra = dados.dataCompra();
    }

    public Compra(Long id, Integer valor) {
        this.id = id;
        this.valor = valor;
    }
    public void atualizarInfo(CompraDTOResponse dados) {
        if (dados.idItem() != null) {
            this.idItem = dados.idItem();
        }
        if (dados.qtdItem() != null) {
            this.qtdItem = dados.qtdItem();
        }
        if (dados.valor() != null) {
            this.valor = dados.valor();
        }
        if (dados.validade() != null) {
            this.validade = dados.validade();
        }
        if (dados.dataCompra() != null) {
            this.dataCompra = dados.dataCompra();
        }
    }
}
