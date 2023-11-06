package com.example.gestaoOrcamentaria.utils.service;

import com.example.gestaoOrcamentaria.utils.repository.BaseCrudRepository;

public interface BaseCrudService<T, ID> {

    BaseCrudRepository getRepository();
}
