package com.example.gestaoOrcamentaria.service;

import com.example.gestaoOrcamentaria.model.TipoReceita;
import com.example.gestaoOrcamentaria.repository.TipoReceitaRepository;
import com.example.gestaoOrcamentaria.service.api.TipoReceitaService;
import com.example.gestaoOrcamentaria.utils.CollectionMetodsUtils;
import com.example.gestaoOrcamentaria.utils.exceptions.AbstractServiceError;
import com.example.gestaoOrcamentaria.utils.repository.BaseCrudRepository;
import com.example.gestaoOrcamentaria.utils.service.AbstractCrudService;
import org.hibernate.service.spi.ServiceException;
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

    @Override
    protected void validate(TipoReceita entity) throws ServiceException {
        AbstractServiceError serviceError = new AbstractServiceError();

        if(CollectionMetodsUtils.isNotObjectEmpty(entity)){
            if (CollectionMetodsUtils.isStringEmpty(entity.getNome())){
                serviceError.addErrorMessage("O Nome da Receita é Obrigatorio!");
            }
            if(CollectionMetodsUtils.isDateNull(entity.getDataCriacao())){
                serviceError.addErrorMessage("A data da criação deve ser Informada!");
            }
        }
        serviceError.assertEmpty();

        super.validate(entity);
    }
}
