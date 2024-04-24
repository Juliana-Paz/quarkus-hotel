package br.unitins.topicos2.ano2024.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.dto.TelefoneDTO;
import br.unitins.topicos2.ano2024.dto.UsuarioDTO;
import br.unitins.topicos2.ano2024.dto.UsuarioResponseDTO;
import br.unitins.topicos2.ano2024.model.Telefone;
import br.unitins.topicos2.ano2024.model.Perfil;
import br.unitins.topicos2.ano2024.model.Usuario;
import br.unitins.topicos2.ano2024.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    Validator validator;

    @Override
    public List<UsuarioResponseDTO> getAll(int page, int pageSize) {
        List<Usuario> usuarios = usuarioRepository.findAll().page(page, pageSize).list();
        return usuarios.stream().map(UsuarioResponseDTO::valueOf).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UsuarioResponseDTO create(UsuarioDTO usuarioDTO) {

        Usuario entity = new Usuario();

        entity.setNome(usuarioDTO.nome());
        entity.setSobrenome(usuarioDTO.sobrenome());
        entity.setSenha(usuarioDTO.senha());
        entity.setEmail(usuarioDTO.email());
        entity.setDataNascimento(usuarioDTO.dataNascimento());
        entity.setEndereco(usuarioDTO.endereco());
        entity.setCpf(usuarioDTO.cpf());
        entity.setPerfil(Perfil.valueOf(usuarioDTO.perfilId()));

        if (usuarioDTO.telefones() != null && !usuarioDTO.telefones().isEmpty()) {
            for (TelefoneDTO telefoneDTO : usuarioDTO.telefones()) {
                Telefone telefone = new Telefone();
                telefone.setNumero(telefoneDTO.numero());
                entity.getTelefones().add(telefone);
            }
        }

        usuarioRepository.persist(entity);

        return UsuarioResponseDTO.valueOf(entity);

    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(Long id, UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        validar(usuarioDTO);

        Usuario entity = usuarioRepository.findById(id);

        entity.setNome(usuarioDTO.nome());
        entity.setSobrenome(usuarioDTO.sobrenome());
        entity.setSenha(usuarioDTO.senha());
        entity.setEmail(usuarioDTO.email());
        entity.setDataNascimento(usuarioDTO.dataNascimento());
        entity.setEndereco(usuarioDTO.endereco());
        entity.setCpf(usuarioDTO.cpf());
        entity.setPerfil(Perfil.valueOf(usuarioDTO.perfilId()));

        if (usuarioDTO.telefones() != null && !usuarioDTO.telefones().isEmpty()) {
            for (TelefoneDTO telefoneDTO : usuarioDTO.telefones()) {
                Telefone telefone = new Telefone();
                telefone.setNumero(telefoneDTO.numero());
                entity.getTelefones().add(telefone);
            }
        }

        usuarioRepository.persist(entity);

        return UsuarioResponseDTO.valueOf(entity);
    }

    private void validar(UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<UsuarioDTO>> violations = validator.validate(usuarioDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id);
        if (usuario == null)
            throw new NotFoundException("Usuario não encontrado.");
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public long count() {
        return usuarioRepository.count();
    }
}
