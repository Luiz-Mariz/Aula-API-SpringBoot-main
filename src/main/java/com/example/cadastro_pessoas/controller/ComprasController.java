package com.example.cadastro_pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro_pessoas.model.ComprasModel;
import com.example.cadastro_pessoas.servicer.ComprasService;

@RestController

@RequestMapping("/api/compras")
public class ComprasController {
    
    @Autowired
    private ComprasService service;

    @GetMapping
    public List<ComprasModel> listarTodos(){
        return service.listarTodos();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<ComprasModel> buscarPorID(@PathVariable Long id){
        return service.buscarPorID(id)
               .map(ResponseEntity:: ok)
               .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ComprasModel salvar(@RequestBody ComprasModel comprasModel){
        return service.salvar(comprasModel);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ComprasModel> atualizar(@PathVariable Long id, @RequestBody ComprasModel comprasModel){

        if(!service.buscarPorID(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        comprasModel.setId(id);

        return ResponseEntity.ok(service.salvar(comprasModel));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ComprasModel> deletar(@PathVariable Long id){

        if (!service.buscarPorID(id).isPresent()) {
            return ResponseEntity.notFound().build();

        }

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
