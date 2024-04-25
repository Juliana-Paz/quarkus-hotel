package br.unitins.topicos2.ano2024.dto;

import java.time.YearMonth;

import br.unitins.topicos2.ano2024.model.CupomDesconto;

public record CupomDescontoResponseDTO(

        Long id,
        String codigo,
        String descricao,
        double valor,
        YearMonth dataValidade,
        TipoQuartoResponseDTO tipoQuarto
) 

{
            
    public static CupomDescontoResponseDTO valueOf(CupomDesconto cupomDesconto) {
        return new CupomDescontoResponseDTO(
                cupomDesconto.getId(),
                cupomDesconto.getCodigo(),
                cupomDesconto.getDescricao(),
                cupomDesconto.getValor(),
                cupomDesconto.getDataValidade(),
                TipoQuartoResponseDTO.valueOf(cupomDesconto.getTipoQuarto()));
    }
}
