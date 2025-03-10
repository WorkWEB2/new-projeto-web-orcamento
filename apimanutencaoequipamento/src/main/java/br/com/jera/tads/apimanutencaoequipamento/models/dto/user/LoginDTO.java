package br.com.jera.tads.apimanutencaoequipamento.models.dto.user;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO (@NotBlank(message = "o email precisa ser preenchido")
                        String email,
                        @NotBlank(message = "a senha precisa ser preenchida")
                        String password){

}
