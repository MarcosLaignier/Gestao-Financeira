package com.example.gestaoOrcamentaria.repository;

import com.example.gestaoOrcamentaria.model.TipoDespesa;
import com.example.gestaoOrcamentaria.utils.repository.BaseCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDespesaRepository extends BaseCrudRepository<TipoDespesa, Integer> {
}
