package br.unitins.topicos2.ano2024.dto;

import java.time.LocalDate;

public record PromocaoDTO(
        String nome,
        String descricao,
        double valor,
        LocalDate dataInicio,
        LocalDate dataFim,
        Long id_tipoQuarto
) {

}
