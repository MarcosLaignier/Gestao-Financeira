package com.example.gestaoOrcamentaria.service;

import com.example.gestaoOrcamentaria.enums.TipoMovimentoEnum;
import com.example.gestaoOrcamentaria.model.MovimentoFinanceiro;
import com.example.gestaoOrcamentaria.repository.MovimentoFinanceiroRepository;
import com.example.gestaoOrcamentaria.service.api.MovimentoFinanceiroService;
import com.example.gestaoOrcamentaria.utils.repository.BaseCrudRepository;
import com.example.gestaoOrcamentaria.utils.service.AbstractCrudService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class MovimentoFinanceiroServiceImpl extends AbstractCrudService<MovimentoFinanceiro, Integer> implements MovimentoFinanceiroService {

    @Autowired
    private MovimentoFinanceiroRepository repository;

    @Override
    protected void beforeSave(MovimentoFinanceiro entity) throws ServiceException {
        super.beforeSave(entity);
        if(entity.getTipoMovimento() == TipoMovimentoEnum.DESPESA){
            entity.setValorDigitado(entity.getValorDigitado().multiply(new BigDecimal(-1)));
            entity.setValorTotal(entity.getValorTotal().multiply(new BigDecimal(-1)));
        }
    }

    @Override
    public BaseCrudRepository getRepository() {
        return repository;
    }
}
