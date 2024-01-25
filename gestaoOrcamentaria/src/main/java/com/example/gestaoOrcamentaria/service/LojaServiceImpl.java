package com.example.gestaoOrcamentaria.service;

import com.example.gestaoOrcamentaria.model.Funcionario;
import com.example.gestaoOrcamentaria.model.Loja;
import com.example.gestaoOrcamentaria.model.TipoReceita;
import com.example.gestaoOrcamentaria.repository.FuncionarioRepository;
import com.example.gestaoOrcamentaria.repository.LojaRepository;
import com.example.gestaoOrcamentaria.service.api.FuncionarioService;
import com.example.gestaoOrcamentaria.service.api.LojaService;
import com.example.gestaoOrcamentaria.utils.CollectionMetodsUtils;
import com.example.gestaoOrcamentaria.utils.exceptions.AbstractServiceError;
import com.example.gestaoOrcamentaria.utils.repository.BaseCrudRepository;
import com.example.gestaoOrcamentaria.utils.service.AbstractCrudService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaServiceImpl extends AbstractCrudService<Loja, Integer> implements LojaService {

    @Autowired
    private LojaRepository repository;

    @Override
    public BaseCrudRepository getRepository() {
        return repository;
    }

    @Override
    protected void validate(Loja entity) throws ServiceException {
        AbstractServiceError serviceError = new AbstractServiceError();

        if(CollectionMetodsUtils.isNotObjectEmpty(entity)){
            if (CollectionMetodsUtils.isStringEmpty(entity.getNome())){
                serviceError.addErrorMessage("O Nome da empresa é Obrigatorio!");
            }
            if(CollectionMetodsUtils.isDateNull(entity.getDataCriacao())){
                serviceError.addErrorMessage("A data da criação deve ser Informada!");
            }
            if(entity.getSituacao() == null){
                serviceError.addErrorMessage("A situação deve ser Informada!");
            }
        }
        serviceError.assertEmpty();

        super.validate(entity);
    }
}
