package com.helpcom.api.Producao;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record ProducaoDTOResponse(Long id, Long idReceita, Long precoCusto, BigDecimal precoFinal) {
    public ProducaoDTOResponse(Producao producao) {
        this(producao.getId(), producao.getIdReceita(), producao.getValor(), calcularPrecoFinal(producao));
    }

    private static BigDecimal calcularPrecoFinal(Producao producao) {
        BigDecimal valor = BigDecimal.valueOf(producao.getValor());
        BigDecimal margemLucro = BigDecimal.valueOf(producao.getMargemLucro());
        BigDecimal precoFinal = valor.add(valor.multiply(margemLucro)).setScale(2, RoundingMode.HALF_UP);

        return precoFinal.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
}
