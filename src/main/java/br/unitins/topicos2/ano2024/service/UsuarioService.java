package br.unitins.topicos2.ano2024.service;

import java.util.List;

import br.unitins.topicos2.ano2024.dto.UsuarioDTO;
import br.unitins.topicos2.ano2024.dto.UsuarioResponseDTO;

public interface UsuarioService {

    List<UsuarioResponseDTO> getAll(int page, int pageSize);
    
    UsuarioResponseDTO create(UsuarioDTO usuario);   
    
}
