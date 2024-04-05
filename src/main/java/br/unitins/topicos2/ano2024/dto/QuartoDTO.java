package br.unitins.topicos2.ano2024.dto;

import java.util.List;

import br.unitins.topicos2.ano2024.model.TipoQuarto;

public record QuartoDTO(

        String nome,
        double valor,
        String descricao,
        boolean isDisponivel,
        List<TipoQuartoDTO> tipoQuarto,
        List<AmenidadeDTO> amenidades

) {

}
