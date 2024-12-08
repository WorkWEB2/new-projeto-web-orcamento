package br.com.jera.tads.apimanutencaoequipamento.repositories;

import br.com.jera.tads.apimanutencaoequipamento.models.entity.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao , Long> , JpaSpecificationExecutor<Solicitacao>{

    List<Solicitacao> findByClient_id(Long id);

    List<Solicitacao> findByFuncionario_id(Long id);

}
