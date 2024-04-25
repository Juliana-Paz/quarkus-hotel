package br.unitins.topicos2.ano2024.service;

import br.unitins.topicos2.ano2024.dto.CupomDescontoDTO;
import br.unitins.topicos2.ano2024.dto.CupomDescontoResponseDTO;
import br.unitins.topicos2.ano2024.model.CupomDesconto;
import br.unitins.topicos2.ano2024.repository.CupomDescontoRepository;
import br.unitins.topicos2.ano2024.repository.TipoQuartoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CupomDescontoServiceImpl implements CupomDescontoService {

    @Inject
    CupomDescontoRepository cupomDescontoRepository;

    @Inject
    TipoQuartoRepository tipoQuartoRepository;

    @Override
    @Transactional
    public List<CupomDescontoResponseDTO> getAll(int page, int pageSize) {
        return cupomDescontoRepository.findAll()
                .page(page, pageSize)
                .stream()
                .map(CupomDescontoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CupomDescontoResponseDTO findById(Long id) {
        CupomDesconto cupomDesconto = cupomDescontoRepository.findById(id);
        if (cupomDesconto == null) {
            throw new NotFoundException("Cupom de desconto não encontrado.");
        }
        return CupomDescontoResponseDTO.valueOf(cupomDesconto);
    }

    @Override
    @Transactional
    public CupomDescontoResponseDTO create(CupomDescontoDTO cupomDescontoDTO) {

        CupomDesconto cupomDesconto = new CupomDesconto();

        cupomDesconto.setCodigo(cupomDescontoDTO.codigo());
        cupomDesconto.setDescricao(cupomDescontoDTO.descricao());
        cupomDesconto.setValor(cupomDescontoDTO.valor());
        cupomDesconto.setDataValidade(cupomDescontoDTO.dataValidade());
        cupomDesconto.setTipoQuarto(tipoQuartoRepository.findById(cupomDescontoDTO.id_tipoQuarto()));
        cupomDescontoRepository.persist(cupomDesconto);
        return CupomDescontoResponseDTO.valueOf(cupomDesconto);
    }

    @Override
    @Transactional
    public CupomDescontoResponseDTO update(Long id, CupomDescontoDTO cupomDescontoDTO) {
        CupomDesconto cupomDesconto = cupomDescontoRepository.findById(id);
        if (cupomDesconto == null) {
            throw new NotFoundException("Cupom de desconto não encontrado.");
        }
        cupomDesconto.setCodigo(cupomDescontoDTO.codigo());
        cupomDesconto.setDescricao(cupomDescontoDTO.descricao());
        cupomDesconto.setValor(cupomDescontoDTO.valor());
        cupomDesconto.setDataValidade(cupomDescontoDTO.dataValidade());
        cupomDesconto.setTipoQuarto(tipoQuartoRepository.findById(cupomDescontoDTO.id_tipoQuarto()));
        cupomDescontoRepository.persist(cupomDesconto);
        return CupomDescontoResponseDTO.valueOf(cupomDesconto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cupomDescontoRepository.deleteById(id);
    }

    @Override
    public long count() {
        return cupomDescontoRepository.count();
    }
}
