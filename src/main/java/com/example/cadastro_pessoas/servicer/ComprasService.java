package com.example.cadastro_pessoas.servicer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro_pessoas.model.ComprasModel;
import com.example.cadastro_pessoas.repository.ComprasRepository;

@Service
public class ComprasService {
    @Autowired
    private ComprasRepository repository;

    public List<ComprasModel> listarTodos(){
        return repository.findAll();
    }

    public Optional<ComprasModel> buscarPorID(Long id){
        return repository.findById(id);
    }

    public ComprasModel salvar(ComprasModel ComprasModel){
        return repository.save(ComprasModel);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
