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

import com.example.cadastro_pessoas.model.ItensCompraModel;
import com.example.cadastro_pessoas.servicer.ItensCompraSevice;


@RestController

@RequestMapping("/api/itensCompra")
public class ItensCompraController {

     @Autowired
    private ItensCompraSevice service;

    @GetMapping
    public List<ItensCompraModel> listarTodos(){
        return service.listarTodos();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<ItensCompraModel> buscarPorID(@PathVariable Long id){
        return service.buscarPorID(id)
               .map(ResponseEntity:: ok)
               .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ItensCompraModel salvar(@RequestBody ItensCompraModel itensCompraModel){
        return service.salvar(itensCompraModel);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ItensCompraModel> atualizar(@PathVariable Long id, @RequestBody ItensCompraModel itensCompraModel){

        if(!service.buscarPorID(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        itensCompraModel.setId(id);

        return ResponseEntity.ok(service.salvar(itensCompraModel));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ItensCompraModel> deletar(@PathVariable Long id){

        if (!service.buscarPorID(id).isPresent()) {
            return ResponseEntity.notFound().build();

        }

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}

