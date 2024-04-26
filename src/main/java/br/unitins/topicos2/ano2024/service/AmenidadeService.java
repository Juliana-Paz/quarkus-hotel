package br.unitins.topicos2.ano2024.service;

import br.unitins.topicos2.ano2024.dto.AmenidadeDTO;
import br.unitins.topicos2.ano2024.dto.AmenidadeResponseDTO;

import java.util.List;

public interface AmenidadeService {

    List<AmenidadeResponseDTO> getAll(int page, int pageSize);

    List<AmenidadeResponseDTO> getAll();

    AmenidadeResponseDTO findById(Long id);

    AmenidadeResponseDTO create(AmenidadeDTO amenidadeDTO);

    AmenidadeResponseDTO update(Long id, AmenidadeDTO amenidadeDTO);

    void delete(Long id);

    long count();
}
