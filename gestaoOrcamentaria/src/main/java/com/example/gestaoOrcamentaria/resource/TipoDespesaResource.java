package com.example.gestaoOrcamentaria.resource;


import com.example.gestaoOrcamentaria.model.TipoDespesa;
import com.example.gestaoOrcamentaria.service.TipoDespesaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/tipoDespesa")
public class TipoDespesaResource {

    @Autowired
    private TipoDespesaServiceImpl tipoDespesaService;

    @GetMapping
    public ResponseEntity<List<TipoDespesa>> findAll() {
        List<TipoDespesa> acrescimos = tipoDespesaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(acrescimos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDespesa> findById(@PathVariable Integer id) {
        TipoDespesa acrescimo = tipoDespesaService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(acrescimo);
    }

    @PostMapping
    public ResponseEntity<TipoDespesa> create(@RequestBody TipoDespesa novoAcrescimo) {
        TipoDespesa acrescimo = tipoDespesaService.save(novoAcrescimo);
        return ResponseEntity.status(HttpStatus.CREATED).body(acrescimo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDespesa> update(@RequestBody TipoDespesa acrescimoAtualizado){
        TipoDespesa acrescimo = tipoDespesaService.update(acrescimoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(acrescimo);
    }

    @DeleteMapping
    public ResponseEntity<TipoDespesa> delete(@RequestBody TipoDespesa entity){
        tipoDespesaService.delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

