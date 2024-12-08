package br.com.jera.tads.apimanutencaoequipamento.models.dto.funcionario;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FuncionarioEditDTO(Long id ,
                                 @NotBlank(message = "o nome é obrigatório") String nome ,
                                 @NotBlank(message = "o email é obrigatório") String email  ,
                                 @NotNull(message = "a data de nascimento é obrigatória")  @JsonFormat(pattern = "yyyy-MM-dd") LocalDate dtNascimento) {

}