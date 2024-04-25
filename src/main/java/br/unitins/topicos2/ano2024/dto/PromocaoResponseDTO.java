package br.unitins.topicos2.ano2024.dto;

import java.time.LocalDate;

import br.unitins.topicos2.ano2024.model.Promocao;

public record PromocaoResponseDTO(
        Long id,
        String nome,
        String descricao,
        double valor,
        LocalDate dataInicio,
        LocalDate dataFim,
        TipoQuartoResponseDTO tipoQuarto
) {
    public static PromocaoResponseDTO valueOf(Promocao promocao) {
        return new PromocaoResponseDTO(
                promocao.getId(),
                promocao.getNome(),
                promocao.getDescricao(),
                promocao.getValor(),
                LocalDate.from(promocao.getDataInicio()),
                LocalDate.from(promocao.getDataFim()),
                TipoQuartoResponseDTO.valueOf(promocao.getTipoQuarto())
        );
    }
}
