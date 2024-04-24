package br.unitins.topicos2.ano2024.service;

import br.unitins.topicos2.ano2024.dto.TipoQuartoDTO;
import br.unitins.topicos2.ano2024.dto.TipoQuartoResponseDTO;

import java.util.List;

public interface TipoQuartoService {

    List<TipoQuartoResponseDTO> getAll(int page, int pageSize);

    TipoQuartoResponseDTO findById(Long id);

    TipoQuartoResponseDTO create(TipoQuartoDTO tipoQuartoDTO);

    void delete(Long id);

    TipoQuartoResponseDTO update(Long id, TipoQuartoDTO tipoQuartoDTO);

    long count();
}
