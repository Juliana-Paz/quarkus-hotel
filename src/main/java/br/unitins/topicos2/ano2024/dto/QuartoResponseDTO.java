package br.unitins.topicos2.ano2024.dto;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.model.Quarto;
import br.unitins.topicos2.ano2024.model.TipoQuarto;

public record QuartoResponseDTO(

        Long id,
        String nome,
        double valor,
        String descricao,
        boolean isDisponivel,
        List<TipoQuartoResponseDTO> tipoQuarto,
        List<AmenidadeResponseDTO> amenidade

)

{
    public static QuartoResponseDTO valueOf(Quarto quarto) {
        return new QuartoResponseDTO(quarto.getId(),
                quarto.getNome(),
                quarto.getValor(),
                quarto.getDescricao(),
                quarto.isDisponivel(),
                quarto.getTipoQuarto().stream().map(TipoQuartoResponseDTO::valueOf).collect(Collectors.toList()),
                quarto.getAmenidade().stream().map(AmenidadeResponseDTO::valueOf).collect(Collectors.toList()));

    }
}
