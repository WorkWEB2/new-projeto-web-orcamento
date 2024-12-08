package br.com.jera.tads.apimanutencaoequipamento.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="movimentacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_hr_movimentacao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dtHrMovimentacao;

    @Enumerated(EnumType.STRING)
    private EstadoSolicitacao estadoMovimentacao;

    @ManyToOne
    @JoinColumn(name="funcionario_id")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name="solicitacao_id")
    @JsonBackReference
    private Solicitacao solicitacao;
}