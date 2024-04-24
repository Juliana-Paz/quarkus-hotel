package br.unitins.topicos2.ano2024.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.dto.AmenidadeDTO;
import br.unitins.topicos2.ano2024.dto.QuartoDTO;
import br.unitins.topicos2.ano2024.dto.QuartoResponseDTO;
import br.unitins.topicos2.ano2024.dto.TipoQuartoDTO;
import br.unitins.topicos2.ano2024.model.Amenidade;
import br.unitins.topicos2.ano2024.model.Quarto;
import br.unitins.topicos2.ano2024.model.TipoQuarto;
import br.unitins.topicos2.ano2024.repository.QuartoRepository;
import br.unitins.topicos2.ano2024.repository.TipoQuartoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class QuartoServiceImpl implements QuartoService {

    @Inject
    QuartoRepository quartoRepository;

    @Inject
    TipoQuartoRepository tipoQuartoRepository;

    // @Inject
    // Validator validator;

    @Override
    @Transactional
    public List<QuartoResponseDTO> getAll(int page, int pageSize) {
        List<Quarto> quartos = quartoRepository.findAll().page(page, pageSize).list();
        return quartos.stream().map(QuartoResponseDTO::valueOf).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public QuartoResponseDTO create(QuartoDTO quartoDTO) {

        Quarto entity = new Quarto();

        entity.setNome(quartoDTO.nome());
        entity.setValor(quartoDTO.valor());
        entity.setDescricao(quartoDTO.descricao());
        entity.setDisponivel(true);
        entity.setTipoQuarto(tipoQuartoRepository.findById(quartoDTO.idTipoQuarto()));

        if (quartoDTO.amenidades() != null && !quartoDTO.amenidades().isEmpty()) {
            for (AmenidadeDTO amenidadeDTO : quartoDTO.amenidades()) {
                Amenidade amenidade = new Amenidade();
                amenidade.setNome((amenidadeDTO.nome()));
                entity.getAmenidade().add(amenidade);
            }
        }

        quartoRepository.persist(entity);

        return QuartoResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public QuartoResponseDTO update(Long id, QuartoDTO quartoDTO) {
        Quarto entity = quartoRepository.findById(id);

        entity.setNome(quartoDTO.nome());
        entity.setValor(quartoDTO.valor());
        entity.setDescricao(quartoDTO.descricao());
        entity.setDisponivel(true);
        entity.setTipoQuarto(tipoQuartoRepository.findById(quartoDTO.idTipoQuarto()));

        if (quartoDTO.amenidades() != null && !quartoDTO.amenidades().isEmpty()) {
            for (AmenidadeDTO amenidadeDTO : quartoDTO.amenidades()) {
                Amenidade amenidade = new Amenidade();
                amenidade.setNome((amenidadeDTO.nome()));
                entity.getAmenidade().add(amenidade);
            }
        }

        return QuartoResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        quartoRepository.deleteById(id);
    }

    @Override
    public QuartoResponseDTO findById(Long id) {
        Quarto quarto = quartoRepository.findById(id);
        if (quarto == null)
            throw new NotFoundException("Quarto não encontrado.");
        return QuartoResponseDTO.valueOf(quarto);
    }

    @Override
    public long count() {
        return quartoRepository.count();
    }
}