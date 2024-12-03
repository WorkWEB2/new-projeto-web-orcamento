package br.com.jera.tads.apimanutencaoequipamento.modules.cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    @NotNull
    private String cpf;

    @Email(message = "O campo (email) deve conter um email válido")
    private String email;
    @Email(message = "O campo (confirmar email) deve conter um email válido")
    private String confirmEmail;
    private String cep;
    private double numero;
    private String endereco;
    private String localidade;
    private String estado;
    private String telefone;
    private String perfil;

    @Length(min = 2, max = 100)
    private String senha;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
