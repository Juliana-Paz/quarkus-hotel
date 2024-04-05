package br.unitins.topicos2.ano2024.dto;

import br.unitins.topicos2.ano2024.model.Amenidade;

public record AmenidadeResponseDTO(
    Long id,
    String nome
) {
    public  static AmenidadeResponseDTO valueOf(Amenidade amenidade) {
        return new AmenidadeResponseDTO(amenidade.getId(),
         amenidade.getNome());
        
    }
}
