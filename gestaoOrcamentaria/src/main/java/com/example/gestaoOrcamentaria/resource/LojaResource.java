package com.example.gestaoOrcamentaria.resource;

import com.example.gestaoOrcamentaria.model.Loja;
import com.example.gestaoOrcamentaria.service.LojaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/loja")
public class LojaResource {

    @Autowired
    private LojaServiceImpl lojaService;

    @GetMapping
    public ResponseEntity<List<Loja>> findAll() {
        List<Loja> lojas = lojaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(lojas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loja> findById(@PathVariable Integer id) {
        Loja loja = lojaService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(loja);
    }

    @PostMapping
    public ResponseEntity<Loja> create(@RequestBody Loja novaLoja) {
        Loja loja = lojaService.save(novaLoja);
        return ResponseEntity.status(HttpStatus.CREATED).body(loja);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loja> update(@RequestBody Loja lojaAtualizada){
        Loja loja = lojaService.update(lojaAtualizada);
        return ResponseEntity.status(HttpStatus.OK).body(loja);
    }

    @DeleteMapping
    public ResponseEntity<Loja> delete(@RequestBody Loja entity){
        lojaService.delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
