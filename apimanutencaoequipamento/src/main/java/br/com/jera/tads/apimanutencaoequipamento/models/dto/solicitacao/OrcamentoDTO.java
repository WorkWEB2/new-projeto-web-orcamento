package br.com.jera.tads.apimanutencaoequipamento.models.dto.solicitacao;

import java.math.BigDecimal;

public record OrcamentoDTO(
        String justificativaRejeicao,
        BigDecimal valorOrcamento) {

}