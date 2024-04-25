package br.unitins.topicos2.ano2024.dto;

import java.time.YearMonth;

import br.unitins.topicos2.ano2024.model.Promocao;

public record PromocaoResponseDTO(
        Long id,
        String nome,
        String descricao,
        double valor,
        // YearMonth dataInicio,
        // YearMonth dataFim,
        TipoQuartoResponseDTO tipoQuarto
) {
    public static PromocaoResponseDTO valueOf(Promocao promocao) {
        return new PromocaoResponseDTO(
                promocao.getId(),
                promocao.getNome(),
                promocao.getDescricao(),
                promocao.getValor(),
                // YearMonth.from(promocao.getDataInicio()),
                // YearMonth.from(promocao.getDataFim()),
                TipoQuartoResponseDTO.valueOf(promocao.getTipoQuarto())
        );
    }
}
