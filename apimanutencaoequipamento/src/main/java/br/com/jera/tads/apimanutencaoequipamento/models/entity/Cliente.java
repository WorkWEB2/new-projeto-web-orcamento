package br.com.jera.tads.apimanutencaoequipamento.models.entity;

import org.springframework.data.relational.core.mapping.Table;

import br.com.jera.tads.apimanutencaoequipamento.models.dto.cliente.ClienteFormDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Cliente extends User{

    @Column(name="CPF" , length = 11 , unique = true)
    private String cpf;
    @Column(name="ENDERECO" , length = 100)
    private String endereco;
    @Column(name="CIDADE" , length = 100)
    private String cidade;
    @Column(name="ESTADO" , length = 50)
    private String estado;
    private int numero;
    @Column(name="CEP" , length = 8)
    private String cep;

    public Cliente(ClienteFormDTO clienteDTO) {
        super(clienteDTO.email(),clienteDTO.nome() ,  clienteDTO.celular() , true);
        this.cpf = clienteDTO.cpf();
        this.cep = clienteDTO.cep();
        this.numero = clienteDTO.numero();
        this.endereco = clienteDTO.endereco();
        this.cidade = clienteDTO.cidade();
        this.estado = clienteDTO.estado();

    }


}

