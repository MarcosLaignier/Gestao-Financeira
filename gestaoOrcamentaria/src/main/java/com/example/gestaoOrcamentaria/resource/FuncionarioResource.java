package com.example.gestaoOrcamentaria.resource;


import com.example.gestaoOrcamentaria.model.Funcionario;
import com.example.gestaoOrcamentaria.model.TipoDespesa;
import com.example.gestaoOrcamentaria.service.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/funcionario")
public class FuncionarioResource {

    @Autowired
    private FuncionarioServiceImpl funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {
        List<Funcionario> acrescimos = funcionarioService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(acrescimos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Integer id) {
        Funcionario acrescimo = funcionarioService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(acrescimo);
    }

    @PostMapping
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario novoAcrescimo) {
        Funcionario acrescimo = funcionarioService.save(novoAcrescimo);
        return ResponseEntity.status(HttpStatus.CREATED).body(acrescimo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@RequestBody Funcionario acrescimoAtualizado){
        Funcionario acrescimo = funcionarioService.update(acrescimoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(acrescimo);
    }

    @DeleteMapping
    public ResponseEntity<TipoDespesa> delete(@RequestBody Funcionario entity){
        funcionarioService.delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

