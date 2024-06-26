package br.unitins.topicos2.ano2024.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.dto.QuartoDTO;
import br.unitins.topicos2.ano2024.dto.QuartoResponseDTO;
import br.unitins.topicos2.ano2024.model.Amenidade;
import br.unitins.topicos2.ano2024.model.Quarto;
import br.unitins.topicos2.ano2024.repository.AmenidadeRepository;
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

    @Inject
    AmenidadeRepository amenidadeRepository;

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
        entity.setReservado(quartoDTO.isReservado());
        entity.setAtivo(quartoDTO.isAtivo());
        entity.setTipoQuarto(tipoQuartoRepository.findById(quartoDTO.idTipoQuarto()));

        List<Amenidade> amenidades = amenidadeRepository.findByIds(quartoDTO.ids_amenidades());
        entity.setAmenidade(amenidades);

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
        entity.setReservado(quartoDTO.isReservado());
        entity.setAtivo(quartoDTO.isAtivo());
        entity.setTipoQuarto(tipoQuartoRepository.findById(quartoDTO.idTipoQuarto()));

        List<Amenidade> amenidades = amenidadeRepository.findByIds(quartoDTO.ids_amenidades());
        entity.setAmenidade(amenidades);

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