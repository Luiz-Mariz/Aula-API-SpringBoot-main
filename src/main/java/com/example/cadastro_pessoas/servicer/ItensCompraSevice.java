package com.example.cadastro_pessoas.servicer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro_pessoas.model.ItensCompraModel;
import com.example.cadastro_pessoas.repository.ItensCompraRepository;

@Service
public class ItensCompraSevice {
    
     @Autowired
    private ItensCompraRepository repository;

    public List<ItensCompraModel> listarTodos(){
        return repository.findAll();
    }

    public Optional<ItensCompraModel> buscarPorID(Long id){
        return repository.findById(id);
    }

    public ItensCompraModel salvar(ItensCompraModel itensCompraModel){
        return repository.save(itensCompraModel);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
