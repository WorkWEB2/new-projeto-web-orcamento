package br.com.jera.tads.apimanutencaoequipamento.models.dto.solicitacao;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OrcamentoFormDTO(
        @NotNull Long id,
        @NotNull BigDecimal valorOrcamento) {

}
