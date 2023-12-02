package com.example.gestaoOrcamentaria.resource;


import com.example.gestaoOrcamentaria.model.Fornecedor;
import com.example.gestaoOrcamentaria.model.Funcionario;
import com.example.gestaoOrcamentaria.model.TipoDespesa;
import com.example.gestaoOrcamentaria.service.FornecedorServiceImpl;
import com.example.gestaoOrcamentaria.service.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/fornecedor")
public class FornecedorResource {

    @Autowired
    private FornecedorServiceImpl fornecedorService;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> findAll() {
        List<Fornecedor> fornecedors = fornecedorService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(fornecedors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Integer id) {
        Fornecedor fornecedor = fornecedorService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(fornecedor);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> create(@RequestBody Fornecedor fornecedorNovo) {
        Fornecedor fornecedor = fornecedorService.save(fornecedorNovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@RequestBody Fornecedor fornecedorAtualizado){
        Fornecedor fornecedor = fornecedorService.update(fornecedorAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorAtualizado);
    }

    @DeleteMapping
    public ResponseEntity<TipoDespesa> delete(@RequestBody Fornecedor entity){
        fornecedorService.delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

