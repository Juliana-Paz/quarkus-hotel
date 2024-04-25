package br.unitins.topicos2.ano2024.service;

import br.unitins.topicos2.ano2024.dto.ServicoDTO;
import br.unitins.topicos2.ano2024.dto.ServicoResponseDTO;

import java.util.List;

public interface ServicoService {

    List<ServicoResponseDTO> getAll(int page, int pageSize);

    ServicoResponseDTO findById(Long id);

    ServicoResponseDTO create(ServicoDTO servicoDTO);

    ServicoResponseDTO update(Long id, ServicoDTO servicoDTO);

    void delete(Long id);

    long count();
}
