package com.example.gestaoOrcamentaria.resource;


import com.example.gestaoOrcamentaria.model.MovimentoFinanceiro;
import com.example.gestaoOrcamentaria.service.MovimentoFinanceiroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/movimento-financeiro")
public class MovimentoFinanceiroResource {

    @Autowired
    private MovimentoFinanceiroServiceImpl movimentoFinanceiroService;

    @GetMapping
    public ResponseEntity<List<MovimentoFinanceiro>> findAll() {
        List<MovimentoFinanceiro> fornecedors = movimentoFinanceiroService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(fornecedors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimentoFinanceiro> findById(@PathVariable Integer id) {
        MovimentoFinanceiro fornecedor = movimentoFinanceiroService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(fornecedor);
    }

    @PostMapping
    public ResponseEntity<MovimentoFinanceiro> create(@RequestBody MovimentoFinanceiro fornecedorNovo) {
        MovimentoFinanceiro fornecedor = movimentoFinanceiroService.save(fornecedorNovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimentoFinanceiro> update(@RequestBody MovimentoFinanceiro fornecedorAtualizado){
        MovimentoFinanceiro fornecedor = movimentoFinanceiroService.update(fornecedorAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovimentoFinanceiro> delete(@PathVariable Integer id){
        if(id != null){
            MovimentoFinanceiro entity = movimentoFinanceiroService.getById(id);
            if(entity != null){
                movimentoFinanceiroService.delete(entity);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }
        return ResponseEntity.notFound().build();

    }


}

