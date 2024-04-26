package br.unitins.topicos2.ano2024.service;

import br.unitins.topicos2.ano2024.dto.AmenidadeDTO;
import br.unitins.topicos2.ano2024.dto.AmenidadeResponseDTO;
import br.unitins.topicos2.ano2024.model.Amenidade;
import br.unitins.topicos2.ano2024.repository.AmenidadeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AmenidadeServiceImpl implements AmenidadeService {

    @Inject
    AmenidadeRepository amenidadeRepository;

    @Override
    @Transactional
    public List<AmenidadeResponseDTO> getAll(int page, int pageSize) {
        return amenidadeRepository.findAll()
                .page(page, pageSize)
                .stream()
                .map(AmenidadeResponseDTO::valueOf)
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional
    public List<AmenidadeResponseDTO> getAll() {
        return amenidadeRepository.findAll()
                .stream()
                .map(AmenidadeResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AmenidadeResponseDTO findById(Long id) {
        Amenidade amenidade = amenidadeRepository.findById(id);
        if (amenidade == null) {
            throw new NotFoundException("Amenidade não encontrada.");
        }
        return AmenidadeResponseDTO.valueOf(amenidade);
    }

    @Override
    @Transactional
    public AmenidadeResponseDTO create(AmenidadeDTO amenidadeDTO) {
        Amenidade amenidade = new Amenidade();
        amenidade.setNome(amenidadeDTO.nome());
        amenidadeRepository.persist(amenidade);
        return AmenidadeResponseDTO.valueOf(amenidade);
    }

    @Override
    @Transactional
    public AmenidadeResponseDTO update(Long id, AmenidadeDTO amenidadeDTO) {
        Amenidade amenidade = amenidadeRepository.findById(id);
        if (amenidade == null) {
            throw new NotFoundException("Amenidade não encontrada.");
        }
        amenidade.setNome(amenidadeDTO.nome());
        return AmenidadeResponseDTO.valueOf(amenidade);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        amenidadeRepository.deleteById(id);
    }

    @Override
    public long count() {
        return amenidadeRepository.count();
    }
}
