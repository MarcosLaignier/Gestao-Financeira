package com.example.gestaoOrcamentaria.repository;

import com.example.gestaoOrcamentaria.model.Fornecedor;
import com.example.gestaoOrcamentaria.utils.repository.BaseCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends BaseCrudRepository<Fornecedor, Integer> {
}
