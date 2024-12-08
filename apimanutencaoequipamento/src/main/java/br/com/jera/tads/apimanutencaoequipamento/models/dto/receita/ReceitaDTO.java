package br.com.jera.tads.apimanutencaoequipamento.models.dto.receita;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ReceitaDTO (LocalDate periodo , String nomeCategoria , BigDecimal valorTotal) {

}