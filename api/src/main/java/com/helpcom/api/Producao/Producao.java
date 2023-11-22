package com.helpcom.api.Producao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Producoes")
@Entity(name = "producao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idReceita;
    private Long valor;
    private Double margemLucro;

    public Producao(ProducaoDTORequest dados, Long valor) {
        this.idReceita = dados.idReceita();
        this.valor = valor;
        this.margemLucro = dados.margemLucro();
    }

    public void atualizarInfo(ProducaoDTOUpdate dados) {
        if (dados.idReceita() != null) {
            this.idReceita = dados.idReceita();
        }
        if (dados.margemLucro() != null) {
            this.margemLucro = dados.margemLucro();
        }
    }
}
