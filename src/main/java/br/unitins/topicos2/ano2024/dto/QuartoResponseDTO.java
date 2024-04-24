package br.unitins.topicos2.ano2024.dto;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.model.Quarto;

public record QuartoResponseDTO(

        Long id,
        String nome,
        double valor,
        String descricao,
        boolean isDisponivel,
        TipoQuartoResponseDTO tipoQuarto,
        List<AmenidadeResponseDTO> amenidade

)

{
    public static QuartoResponseDTO valueOf(Quarto quarto) {
        return new QuartoResponseDTO(
                quarto.getId(),
                quarto.getNome(),
                quarto.getValor(),
                quarto.getDescricao(),
                quarto.isDisponivel(),
                TipoQuartoResponseDTO.valueOf(quarto.getTipoQuarto()),
                quarto.getAmenidade().stream().map(AmenidadeResponseDTO::valueOf).collect(Collectors.toList()));

    }
}
