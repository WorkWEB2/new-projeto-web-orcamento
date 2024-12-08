package br.com.jera.tads.apimanutencaoequipamento.models.dto.solicitacao;

import jakarta.validation.constraints.NotBlank;

public record RejeitarDTO(
        @NotBlank String justificativaRejeicao ) {
}

