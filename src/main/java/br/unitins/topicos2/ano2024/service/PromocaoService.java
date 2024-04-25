package br.unitins.topicos2.ano2024.service;

import br.unitins.topicos2.ano2024.dto.PromocaoDTO;
import br.unitins.topicos2.ano2024.dto.PromocaoResponseDTO;

import java.util.List;

public interface PromocaoService {

    List<PromocaoResponseDTO> getAll(int page, int pageSize);

    PromocaoResponseDTO findById(Long id);

    PromocaoResponseDTO create(PromocaoDTO promocaoDTO);

    void delete(Long id);

    PromocaoResponseDTO update(Long id, PromocaoDTO promocaoDTO);

    long count();
}
