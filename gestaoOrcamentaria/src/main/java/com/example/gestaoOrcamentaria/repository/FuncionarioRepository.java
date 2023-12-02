package com.example.gestaoOrcamentaria.repository;

import com.example.gestaoOrcamentaria.model.Funcionario;
import com.example.gestaoOrcamentaria.utils.repository.BaseCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends BaseCrudRepository<Funcionario, Integer> {
}
