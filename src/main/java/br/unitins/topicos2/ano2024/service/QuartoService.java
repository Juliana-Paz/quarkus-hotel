package br.unitins.topicos2.ano2024.service;

import java.util.List;

import br.unitins.topicos2.ano2024.dto.QuartoDTO;
import br.unitins.topicos2.ano2024.dto.QuartoResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;


public interface QuartoService {

    List<QuartoResponseDTO> getAll(int page, int pageSize);

    QuartoResponseDTO findById(Long id);

    QuartoResponseDTO create(QuartoDTO quartoDTO);

    void delete(Long id);

    QuartoResponseDTO update(Long id, QuartoDTO quartoDTO);
}