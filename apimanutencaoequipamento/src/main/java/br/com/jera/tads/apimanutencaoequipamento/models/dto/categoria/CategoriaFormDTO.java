package br.com.jera.tads.apimanutencaoequipamento.models.dto.categoria;

import jakarta.validation.constraints.NotBlank;

public record CategoriaFormDTO(@NotBlank(message =  "o nome da categoria precisa estar preenchido") String nome) {

}