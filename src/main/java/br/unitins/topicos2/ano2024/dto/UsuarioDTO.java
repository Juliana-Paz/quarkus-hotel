package br.unitins.topicos2.ano2024.dto;

import java.time.LocalDate;
import java.util.List;

public record UsuarioDTO(

    String nome,
    String sobrenome,
    String senha,
    String email,
    String endereco,
    String cpf,
    List<TelefoneDTO> telefones,
    LocalDate dataNascimento,
    Integer perfilId

) {
    


}
