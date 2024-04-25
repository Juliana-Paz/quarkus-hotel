package br.unitins.topicos2.ano2024.dto;

import java.time.YearMonth;

public record CupomDescontoDTO(
        String codigo,
        String descricao,
        double valor,
        YearMonth dataValidade,
        Long id_tipoQuarto
) 

{

}
