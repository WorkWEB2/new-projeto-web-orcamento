package br.com.jera.tads.apimanutencaoequipamento.models.dto.funcionario;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;


public record FuncionarioFormDTO(Long id ,
                                 @NotBlank(message = "o nome é obrigatório") String nome ,
                                 @NotBlank(message = "o email é obrigatório") String email  ,
                                 @NotBlank(message = "a senha é obrigatória") String senha ,
                                 @JsonFormat(pattern = "ddMMyyyy") LocalDate dtNascimento) {

}