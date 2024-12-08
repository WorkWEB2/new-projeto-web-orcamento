package br.com.jera.tads.apimanutencaoequipamento.services;

import br.com.jera.tads.apimanutencaoequipamento.models.projection.VwReceitaCategoriaProjection;
import br.com.jera.tads.apimanutencaoequipamento.models.projection.VwReceitaPeriodoProjection;
import br.com.jera.tads.apimanutencaoequipamento.repositories.VwReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private VwReceitaRepository repository;

    public List<VwReceitaCategoriaProjection> findByCategoria(Long idCategoria) {
        //Specification<VwReceita> specification = new ReceitaSpecification("CATEGORIA", idCategoria);
        return repository.findCategoria(idCategoria);
    }

    public List<VwReceitaPeriodoProjection> findByPeriodo(LocalDate dataInicial , LocalDate dataFinal) {
        if(dataInicial != null && dataFinal != null) {
            return repository.findPeriodo(dataInicial,dataFinal);
        }else{
            return repository.findPeriodo();
        }
    }


}