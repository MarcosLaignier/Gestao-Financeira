package com.example.gestaoOrcamentaria.service;

import com.example.gestaoOrcamentaria.model.Fornecedor;
import com.example.gestaoOrcamentaria.model.Funcionario;
import com.example.gestaoOrcamentaria.repository.FornecedorRepository;
import com.example.gestaoOrcamentaria.repository.FuncionarioRepository;
import com.example.gestaoOrcamentaria.service.api.FornecedorService;
import com.example.gestaoOrcamentaria.service.api.FuncionarioService;
import com.example.gestaoOrcamentaria.utils.repository.BaseCrudRepository;
import com.example.gestaoOrcamentaria.utils.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FornecedorServiceImpl extends AbstractCrudService<Fornecedor, Integer> implements FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Override
    public BaseCrudRepository getRepository() {
        return repository;
    }
}
