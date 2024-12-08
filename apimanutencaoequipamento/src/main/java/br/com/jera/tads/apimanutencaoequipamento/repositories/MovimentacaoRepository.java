package br.com.jera.tads.apimanutencaoequipamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jera.tads.apimanutencaoequipamento.models.entity.Movimentacao;
@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao,Long>{

}
