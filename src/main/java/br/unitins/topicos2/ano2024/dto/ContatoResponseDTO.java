package br.unitins.topicos2.ano2024.dto;

import br.unitins.topicos2.ano2024.model.Contato;

public record ContatoResponseDTO(
    
    Long id,
    String email,
    String telefone) { 

    public static ContatoResponseDTO valueOf(Contato contato) {
        return new ContatoResponseDTO(contato.getId(),
                                      contato.getEmail(),
                                      contato.getTelefone()
                                      );
    }

}
