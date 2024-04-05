package br.unitins.topicos2.ano2024.dto;

import br.unitins.topicos2.ano2024.model.TipoQuarto;

public record TipoQuartoResponseDTO(
    Long id,
    String nome
) {
     public  static TipoQuartoResponseDTO valueOf(TipoQuarto tipoquarto) {
        return new TipoQuartoResponseDTO(tipoquarto.getId(),
         tipoquarto.getNome());
        
    }
}
