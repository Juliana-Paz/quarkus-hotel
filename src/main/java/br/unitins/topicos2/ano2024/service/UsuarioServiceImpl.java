package br.unitins.topicos2.ano2024.service;

import br.unitins.topicos2.ano2024.dto.ContatoDTO;
import br.unitins.topicos2.ano2024.dto.UsuarioDTO;
import br.unitins.topicos2.ano2024.dto.UsuarioResponseDTO;
import br.unitins.topicos2.ano2024.model.Contato;
import br.unitins.topicos2.ano2024.model.Usuario;
import br.unitins.topicos2.ano2024.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService{

    @Inject
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public UsuarioResponseDTO create(UsuarioDTO usuario) {
        
        Usuario newUsuario = new Usuario();
        newUsuario.setNome(usuario.nome());
        newUsuario.setSobrenome(usuario.sobrenome());
        newUsuario.setSenha(usuario.senha());
        //newUsuario.setDataNascimento(usuario.dataNascimento());
        newUsuario.setEndereco(usuario.endereco());
        newUsuario.setCpf(usuario.cpf());
        
        if (usuario.contatos() != null && !usuario.contatos().isEmpty()) {
            for (ContatoDTO contatoDTO : usuario.contatos()) {
                Contato contato = new Contato();
                contato.setEmail(contatoDTO.email());
                contato.setTelefone(contatoDTO.telefone());
                newUsuario.getContatos().add(contato);
            }
        }

        usuarioRepository.persist(newUsuario);
        
        return UsuarioResponseDTO.valueOf(newUsuario);

    }   
    
}
