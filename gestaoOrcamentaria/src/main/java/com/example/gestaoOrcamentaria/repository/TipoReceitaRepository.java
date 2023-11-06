package com.example.gestaoOrcamentaria.repository;

import com.example.gestaoOrcamentaria.model.TipoReceita;
import com.example.gestaoOrcamentaria.utils.repository.BaseCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoReceitaRepository extends BaseCrudRepository<TipoReceita, Integer> {
}
