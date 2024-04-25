package br.unitins.topicos2.ano2024.dto;

import java.time.YearMonth;

public record PromocaoDTO(
        String nome,
        String descricao,
        double valor,
        // YearMonth dataInicio,
        // YearMonth dataFim,
        Long id_promocao
) {

}
