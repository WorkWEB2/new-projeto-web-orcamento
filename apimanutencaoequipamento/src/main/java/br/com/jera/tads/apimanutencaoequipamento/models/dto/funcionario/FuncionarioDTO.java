package br.com.jera.tads.apimanutencaoequipamento.models.dto.funcionario;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.jera.tads.apimanutencaoequipamento.models.entity.Funcionario;

public record FuncionarioDTO(Long id , String nome , String email  , @JsonFormat(pattern =  "yyyy-MM-dd") LocalDate dtNascimento) {
    public FuncionarioDTO(Funcionario funcionario) {
        this(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getEmail(),
                funcionario.getDtNascimento()
        );
    }
}