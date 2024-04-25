package br.unitins.topicos2.ano2024.dto;

import java.time.LocalDate;

public record CupomDescontoDTO(
        String codigo,
        String descricao,
        double valor,
        LocalDate dataValidade,
        Long id_tipoQuarto
) 

{

}
