package br.unitins.topicos2.ano2024.dto;

import br.unitins.topicos2.ano2024.model.Telefone;

public record TelefoneResponseDTO(
    
    Long id,
    String numero) { 

    public static TelefoneResponseDTO valueOf(Telefone telefone) {
        return new TelefoneResponseDTO(telefone.getId(),
                                      telefone.getNumero()
                                      );
    }

}
