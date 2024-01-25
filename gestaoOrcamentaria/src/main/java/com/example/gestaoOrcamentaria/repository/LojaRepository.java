package com.example.gestaoOrcamentaria.repository;

import com.example.gestaoOrcamentaria.model.Loja;
import com.example.gestaoOrcamentaria.utils.repository.BaseCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends BaseCrudRepository<Loja,Integer> {
}
