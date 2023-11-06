package com.example.gestaoOrcamentaria.service;

import com.example.gestaoOrcamentaria.model.TipoReceita;
import com.example.gestaoOrcamentaria.repository.TipoReceitaRepository;
import com.example.gestaoOrcamentaria.service.api.TipoReceitaService;
import com.example.gestaoOrcamentaria.utils.repository.BaseCrudRepository;
import com.example.gestaoOrcamentaria.utils.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TipoReceitaServiceImpl extends AbstractCrudService<TipoReceita, Integer> implements TipoReceitaService {

    @Autowired
    private TipoReceitaRepository repository;

    @Override
    public BaseCrudRepository getRepository() {
        return repository;
    }
}
