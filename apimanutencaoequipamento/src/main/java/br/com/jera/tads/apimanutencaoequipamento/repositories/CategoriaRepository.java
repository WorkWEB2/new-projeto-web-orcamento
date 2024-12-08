package br.com.jera.tads.apimanutencaoequipamento.repositories;

import br.com.jera.tads.apimanutencaoequipamento.models.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria , Long>{

    List<Categoria> findByStatus(boolean b);

}