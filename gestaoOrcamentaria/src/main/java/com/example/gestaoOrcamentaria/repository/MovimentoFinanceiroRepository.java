package com.example.gestaoOrcamentaria.repository;

import com.example.gestaoOrcamentaria.model.MovimentoFinanceiro;
import com.example.gestaoOrcamentaria.utils.repository.BaseCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoFinanceiroRepository extends BaseCrudRepository<MovimentoFinanceiro, Integer> {
}
