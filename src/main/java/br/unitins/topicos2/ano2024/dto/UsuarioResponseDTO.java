package br.unitins.topicos2.ano2024.dto;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.model.Perfil;
import br.unitins.topicos2.ano2024.model.Usuario;

public record UsuarioResponseDTO(

    Long id,
    String nome,
    String sobrenome,
    String senha,
    String email,
    String dataNascimento,
    String endereco,
    String cpf,
    List<TelefoneResponseDTO> telefones,
    Perfil perfil

) {
    
    public static UsuarioResponseDTO valueOf(Usuario usuario) {

        String formattedData = usuario.getDataNascimento() != null
        ? usuario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        : null;
 
        return new UsuarioResponseDTO(usuario.getId(),
                                      usuario.getNome(),
                                      usuario.getSobrenome(),
                                      usuario.getSenha(),
                                      usuario.getEmail(),
                                      formattedData,
                                      usuario.getEndereco(),
                                      usuario.getCpf(),
                                      usuario.getTelefones().stream().map(TelefoneResponseDTO::valueOf).collect(Collectors.toList()),
                                      usuario.getPerfil()
                                      );
    }
}
