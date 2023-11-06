package com.example.gestaoOrcamentaria.resource;


import com.example.gestaoOrcamentaria.model.TipoReceita;
import com.example.gestaoOrcamentaria.service.TipoReceitaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/tipoReceita")
public class TipoReceitaResource {

    @Autowired
    private TipoReceitaServiceImpl tipoReceitaService;

    @GetMapping
    public ResponseEntity<List<TipoReceita>> findAll() {
        List<TipoReceita> acrescimos = tipoReceitaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(acrescimos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoReceita> findById(@PathVariable Integer id) {
        TipoReceita acrescimo = tipoReceitaService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(acrescimo);
    }

    @PostMapping
    public ResponseEntity<TipoReceita> create(@RequestBody TipoReceita novoAcrescimo) {
        TipoReceita acrescimo = tipoReceitaService.save(novoAcrescimo);
        return ResponseEntity.status(HttpStatus.CREATED).body(acrescimo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoReceita> update(@RequestBody TipoReceita acrescimoAtualizado){
        TipoReceita acrescimo = tipoReceitaService.update(acrescimoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(acrescimo);
    }

    @DeleteMapping
    public ResponseEntity<TipoReceita> delete(@RequestBody TipoReceita entity){
        tipoReceitaService.delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

