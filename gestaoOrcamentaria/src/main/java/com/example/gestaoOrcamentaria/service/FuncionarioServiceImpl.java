package com.example.gestaoOrcamentaria.service;

import com.example.gestaoOrcamentaria.model.Funcionario;
import com.example.gestaoOrcamentaria.repository.FuncionarioRepository;
import com.example.gestaoOrcamentaria.service.api.FuncionarioService;
import com.example.gestaoOrcamentaria.utils.repository.BaseCrudRepository;
import com.example.gestaoOrcamentaria.utils.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FuncionarioServiceImpl extends AbstractCrudService<Funcionario, Integer> implements FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public BaseCrudRepository getRepository() {
        return repository;
    }
}
