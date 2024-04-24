package br.unitins.topicos2.ano2024.dto;

import br.unitins.topicos2.ano2024.model.Servico;

public record ServicoResponseDTO(
        Long id,
        String nome,
        String descricao,
        double valor,
        boolean isAtivo
) {
    public static ServicoResponseDTO valueOf(Servico servico) {
        return new ServicoResponseDTO(
                servico.getId(),
                servico.getNome(),
                servico.getDescricao(),
                servico.getValor(),
                servico.isAtivo()
        );
    }
}
