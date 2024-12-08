package br.com.jera.tads.apimanutencaoequipamento.models.projection;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface VwReceitaPeriodoProjection {
    @JsonFormat(pattern = "dd/MM/yyyy")
    public LocalDate getPeriodo();
    public BigDecimal getValor();
}