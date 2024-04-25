package br.unitins.topicos2.ano2024.dto;

import java.util.List;

public record QuartoDTO(

                String nome,
                double valor,
                String descricao,
                boolean isReservado,
                Long idTipoQuarto,
                List<AmenidadeDTO> amenidades

) {

}
