package com.helpcom.api.Receita;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "receitas")
@Entity(name = "receita")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeReceita;
    private String descReceita;
    private String prepReceita;

    public Receita (ReceitaDTORequest dados) {
        this.nomeReceita = dados.nomeReceita();
        this.descReceita = dados.descReceita();
        this.prepReceita = dados.prepReceita();
    }

    public void atualizarInfo(ReceitaDTOResponse dados) {
            if (dados.nomeReceita() != null) {
                this.nomeReceita = dados.nomeReceita();
            }
            if (dados.descReceita() != null) {
                this.descReceita = dados.descReceita();
            }
            if (dados.prepReceita() != null) {
                this.prepReceita = dados.prepReceita();
            }
    }
}
