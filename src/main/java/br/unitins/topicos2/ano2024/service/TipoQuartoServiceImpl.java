package br.unitins.topicos2.ano2024.service;

import br.unitins.topicos2.ano2024.dto.TipoQuartoDTO;
import br.unitins.topicos2.ano2024.dto.TipoQuartoResponseDTO;
import br.unitins.topicos2.ano2024.model.TipoQuarto;
import br.unitins.topicos2.ano2024.repository.TipoQuartoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TipoQuartoServiceImpl implements TipoQuartoService {

    @Inject
    TipoQuartoRepository tipoQuartoRepository;

    @Transactional
    public List<TipoQuartoResponseDTO> getAll(int page, int pageSize) {
        return tipoQuartoRepository.findAll()
                .page(page, pageSize)
                .stream()
                .map(TipoQuartoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Transactional
    public TipoQuartoResponseDTO findById(Long id) {
        TipoQuarto tipoQuarto = tipoQuartoRepository.findById(id);
        if (tipoQuarto == null) {
            throw new NotFoundException("Tipo de quarto não encontrado.");
        }
        return TipoQuartoResponseDTO.valueOf(tipoQuarto);
    }

    @Transactional
    public TipoQuartoResponseDTO create(TipoQuartoDTO tipoQuartoDTO) {
        TipoQuarto tipoQuarto = new TipoQuarto();
        tipoQuarto.setNome(tipoQuartoDTO.nome());
        tipoQuartoRepository.persist(tipoQuarto);
        return TipoQuartoResponseDTO.valueOf(tipoQuarto);
    }

    @Transactional
    public TipoQuartoResponseDTO update(Long id, TipoQuartoDTO tipoQuartoDTO) {
        TipoQuarto tipoQuarto = tipoQuartoRepository.findById(id);
        if (tipoQuarto == null) {
            throw new NotFoundException("Tipo de quarto não encontrado.");
        }
        tipoQuarto.setNome(tipoQuartoDTO.nome());
        return TipoQuartoResponseDTO.valueOf(tipoQuarto);
    }

    @Transactional
    public void delete(Long id) {
        tipoQuartoRepository.deleteById(id);
    }

    public long count() {
        return tipoQuartoRepository.count();
    }
}
