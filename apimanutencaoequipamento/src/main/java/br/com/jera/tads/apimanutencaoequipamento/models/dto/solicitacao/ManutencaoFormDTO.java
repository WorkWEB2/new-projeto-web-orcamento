package br.com.jera.tads.apimanutencaoequipamento.models.dto.solicitacao;

import jakarta.validation.constraints.NotBlank;

public record ManutencaoFormDTO(
        Long id,
        @NotBlank(message = "a descricao da manutenção é obrigatória") String descricaoManutencao,
        @NotBlank(message = "a orientação para o cliente é obrigatória") String orientacaoCliente) {

}