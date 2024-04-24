package br.unitins.topicos2.ano2024.dto;

import br.unitins.topicos2.ano2024.model.TipoQuarto;

public record TipoQuartoResponseDTO(
        Long id,
        String nome,
        PromocaoResponseDTO promocao,
        CupomDescontoResponseDTO cupomDesconto)

{
    public static TipoQuartoResponseDTO valueOf(TipoQuarto tipoQuarto) {
        return new TipoQuartoResponseDTO(
                tipoQuarto.getId(),
                tipoQuarto.getNome(),
                PromocaoResponseDTO.valueOf(tipoQuarto.getPromocao()),
                CupomDescontoResponseDTO.valueOf(tipoQuarto.getCupomDesconto()));
    }
}
