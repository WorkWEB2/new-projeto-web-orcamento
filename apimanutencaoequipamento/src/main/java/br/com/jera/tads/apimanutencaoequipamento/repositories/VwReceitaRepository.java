package br.com.jera.tads.apimanutencaoequipamento.repositories;

import br.com.jera.tads.apimanutencaoequipamento.models.entity.VwReceita;
import br.com.jera.tads.apimanutencaoequipamento.models.projection.VwReceitaCategoriaProjection;
import br.com.jera.tads.apimanutencaoequipamento.models.projection.VwReceitaPeriodoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VwReceitaRepository extends JpaRepository<VwReceita , Long> ,  JpaSpecificationExecutor<VwReceita>{

    @Query(nativeQuery = true , value = "SELECT " +
            " nome_categoria , " +
            " sum(valor) valor " +
            "  FROM VW_RECEITA " +
            "  where  id_categoria = COALESCE(:idCategoria , id_categoria) " +
            " group by nome_categoria " +
            " order by nome_categoria ")
    public List<VwReceitaCategoriaProjection> findCategoria(Long idCategoria);

    @Query(nativeQuery = true , value = "SELECT " +
            "  periodo , " +
            " sum(valor) as valor " +
            "  FROM VW_RECEITA " +
            " group by periodo " +
            " order by periodo ")
    public List<VwReceitaPeriodoProjection> findPeriodo();

    @Query(nativeQuery = true , value = "SELECT " +
            "  periodo , " +
            " sum(valor) as valor " +
            "  FROM VW_RECEITA " +
            "  WHERE  periodo between :dataInicial and :dataFinal " +
            " group by periodo " +
            " order by periodo ")
    public List<VwReceitaPeriodoProjection> findPeriodo(LocalDate dataInicial , LocalDate  dataFinal);
}