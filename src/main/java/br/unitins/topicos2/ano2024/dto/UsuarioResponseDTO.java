package br.unitins.topicos2.ano2024.dto;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.model.Usuario;

public record UsuarioResponseDTO(

    Long id,
    String nome,
    String sobrenome,
    String senha,
    String endereco,
    String cpf,
    List<ContatoResponseDTO> contatos    

) {
    public static UsuarioResponseDTO valueOf(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getId(),
                                      usuario.getNome(),
                                      usuario.getSobrenome(),
                                      usuario.getSenha(),
                                      usuario.getEndereco(),
                                      usuario.getCpf(),
                                      usuario.getContatos().stream().map(ContatoResponseDTO::valueOf).collect(Collectors.toList())
                                      );
    }
}
