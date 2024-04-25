package br.unitins.topicos2.ano2024.service;

import br.unitins.topicos2.ano2024.dto.PromocaoDTO;
import br.unitins.topicos2.ano2024.dto.PromocaoResponseDTO;
import br.unitins.topicos2.ano2024.model.Promocao;
import br.unitins.topicos2.ano2024.repository.PromocaoRepository;
import br.unitins.topicos2.ano2024.repository.TipoQuartoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PromocaoServiceImpl implements PromocaoService {

    @Inject
    PromocaoRepository promocaoRepository;

    @Inject
    TipoQuartoRepository tipoQuartoRepository;

    @Override
    @Transactional
    public List<PromocaoResponseDTO> getAll(int page, int pageSize) {
        return promocaoRepository.findAll()
                .page(page, pageSize)
                .stream()
                .map(PromocaoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PromocaoResponseDTO findById(Long id) {
        Promocao promocao = promocaoRepository.findById(id);
        if (promocao == null) {
            throw new NotFoundException("Promoção não encontrada.");
        }
        return PromocaoResponseDTO.valueOf(promocao);
    }

    @Override
    @Transactional
    public PromocaoResponseDTO create(PromocaoDTO promocaoDTO) {
        Promocao promocao = new Promocao();
        promocao.setNome(promocaoDTO.nome());
        promocao.setDescricao(promocaoDTO.descricao());
        promocao.setDataInicio(promocaoDTO.dataInicio());
        promocao.setDataFim(promocaoDTO.dataFim());
        promocao.setValor(promocaoDTO.valor());
        promocao.setTipoQuarto(tipoQuartoRepository.findById(promocaoDTO.id_tipoQuarto()));
        promocaoRepository.persist(promocao);
        return PromocaoResponseDTO.valueOf(promocao);
    }

    @Override
    @Transactional
    public PromocaoResponseDTO update(Long id, PromocaoDTO promocaoDTO) {
        Promocao promocao = promocaoRepository.findById(id);
        if (promocao == null) {
            throw new NotFoundException("Promoção não encontrada.");
        }
        promocao.setNome(promocaoDTO.nome());
        promocao.setDescricao(promocaoDTO.descricao());
        promocao.setDataInicio(promocaoDTO.dataInicio());
        promocao.setDataFim(promocaoDTO.dataFim());
        promocao.setValor(promocaoDTO.valor());
        promocao.setTipoQuarto(tipoQuartoRepository.findById(promocaoDTO.id_tipoQuarto()));
        return PromocaoResponseDTO.valueOf(promocao);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        promocaoRepository.deleteById(id);
    }

    @Override
    public long count() {
        return promocaoRepository.count();
    }
}
