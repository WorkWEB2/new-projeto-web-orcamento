package br.com.jera.tads.apimanutencaoequipamento.repositories;

import br.com.jera.tads.apimanutencaoequipamento.models.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario , Long>{

    List<Funcionario> findByStatus(boolean b);

    Optional<Funcionario> findByIdAndStatus(Long id, boolean b);

}
