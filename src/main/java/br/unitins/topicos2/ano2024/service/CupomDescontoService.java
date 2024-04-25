package br.unitins.topicos2.ano2024.service;

import br.unitins.topicos2.ano2024.dto.CupomDescontoDTO;
import br.unitins.topicos2.ano2024.dto.CupomDescontoResponseDTO;

import java.util.List;

public interface CupomDescontoService {

    List<CupomDescontoResponseDTO> getAll(int page, int pageSize);

    CupomDescontoResponseDTO findById(Long id);

    CupomDescontoResponseDTO create(CupomDescontoDTO cupomDescontoDTO);

    void delete(Long id);

    CupomDescontoResponseDTO update(Long id, CupomDescontoDTO cupomDescontoDTO);

    long count();
}
