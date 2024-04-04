package br.unitins.topicos2.ano2024.service;

import br.unitins.topicos2.ano2024.dto.UsuarioDTO;
import br.unitins.topicos2.ano2024.dto.UsuarioResponseDTO;

public interface UsuarioService {

    UsuarioResponseDTO create(UsuarioDTO usuario);   
    
}
