package com.backend.service;


import com.backend.entity.Pessoa;
import com.backend.exception.ObjectNotFoundException;
import com.backend.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;



    @Transactional
    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public Pessoa update(Pessoa pessoa){
        findById(pessoa.getId()) ;
        return pessoaRepository.save(pessoa);
    }

    public Pessoa findByNome(String nome){
       return pessoaRepository.findByNome(nome.toUpperCase())
               .orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrada"));
    }


    public Pessoa findById(Long id){
        return pessoaRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Pessoa não encontrado"));
    }


    public Page<Pessoa> findAll(Pageable peageble){
        Page<Pessoa> pessoas = pessoaRepository.findAll(peageble);
        if( pessoas.getTotalPages() < 1) {
            throw  new ObjectNotFoundException("Não há registros");
        }
        return pessoas;
    }
}
