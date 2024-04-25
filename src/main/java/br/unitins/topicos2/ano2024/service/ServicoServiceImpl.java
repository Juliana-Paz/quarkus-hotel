package br.unitins.topicos2.ano2024.service;

import br.unitins.topicos2.ano2024.dto.ServicoDTO;
import br.unitins.topicos2.ano2024.dto.ServicoResponseDTO;
import br.unitins.topicos2.ano2024.model.Servico;
import br.unitins.topicos2.ano2024.repository.ServicoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ServicoServiceImpl implements ServicoService {

    @Inject
    ServicoRepository servicoRepository;

    @Transactional
    public List<ServicoResponseDTO> getAll(int page, int pageSize) {
        return servicoRepository.findAll()
                .page(page, pageSize)
                .stream()
                .map(ServicoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Transactional
    public ServicoResponseDTO findById(Long id) {
        Servico servico = servicoRepository.findById(id);
        if (servico == null) {
            throw new NotFoundException("Serviço não encontrado.");
        }
        return ServicoResponseDTO.valueOf(servico);
    }

    @Transactional
    public ServicoResponseDTO create(ServicoDTO servicoDTO) {
        Servico servico = new Servico();
        servico.setNome(servicoDTO.nome());
        servico.setDescricao(servicoDTO.descricao());
        servico.setValor(servicoDTO.valor());
        servico.setAtivo(servicoDTO.isAtivo());
        servicoRepository.persist(servico);
        return ServicoResponseDTO.valueOf(servico);
    }

    @Transactional
    public ServicoResponseDTO update(Long id, ServicoDTO servicoDTO) {
        Servico servico = servicoRepository.findById(id);
        if (servico == null) {
            throw new NotFoundException("Serviço não encontrado.");
        }
        servico.setNome(servicoDTO.nome());
        servico.setDescricao(servicoDTO.descricao());
        servico.setValor(servicoDTO.valor());
        servico.setAtivo(servicoDTO.isAtivo());
        return ServicoResponseDTO.valueOf(servico);
    }

    @Transactional
    public void delete(Long id) {
        servicoRepository.deleteById(id);
    }

    public long count() {
        return servicoRepository.count();
    }
}
