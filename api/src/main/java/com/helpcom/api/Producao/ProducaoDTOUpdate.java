package com.helpcom.api.Producao;


public record ProducaoDTOUpdate(Long id, Long idReceita, Double margemLucro) {
    public Long getId() {
        return id;
    }
}
