package com.example.gestaoOrcamentaria.service;

import com.example.gestaoOrcamentaria.model.TipoDespesa;
import com.example.gestaoOrcamentaria.repository.TipoDespesaRepository;
import com.example.gestaoOrcamentaria.service.api.TipoDespesaService;
import com.example.gestaoOrcamentaria.utils.repository.BaseCrudRepository;
import com.example.gestaoOrcamentaria.utils.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TipoDespesaServiceImpl extends AbstractCrudService<TipoDespesa, Integer> implements TipoDespesaService {

    @Autowired
    private TipoDespesaRepository repository;

    @Override
    public BaseCrudRepository getRepository() {
        return repository;
    }
}
