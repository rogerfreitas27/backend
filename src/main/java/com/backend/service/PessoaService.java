package com.backend.service;


import com.backend.dto.EnderecoDto;
import com.backend.dto.PessoaDto;
import com.backend.entity.Endereco;
import com.backend.entity.Pessoa;
import com.backend.exception.ObjectNotFoundException;
import com.backend.repository.EnderecoRepository;
import com.backend.repository.PessoaRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;



    @Transactional
    public Pessoa save(PessoaDto pessoaDto){
        Pessoa pessoa = new Pessoa();

        pessoa =  pessoaRepository.save(new Pessoa().convertDtoToPessoa(pessoaDto));

      Set<Endereco> enderecoSet =new HashSet<>();
       for(EnderecoDto end: pessoaDto.getEnderecosDto()){
           Endereco endereco =new Endereco.Builder(null)
                   .logradouro(end.getLogradouro())
                   .cep(end.getCep())
                   .numero(end.getNumero())
                   .cidade(end.getCidade())
                   .principal(false)
                   .pessoa(pessoa)
                   .build();
             pessoa.addEndereco(endereco);
         //  enderecoSet.add(endereco);
       }


            enderecoRepository.saveAll(pessoa.getEndereco());
       return pessoa;
    }

    @Transactional
    public Pessoa update(Pessoa pessoa){

        findById(pessoa.getId()) ;

        pessoa.getEndereco().forEach(endereco->endereco.setPessoa(pessoa));
        pessoa.getEndereco().forEach(endereco->endereco.setPrincipal(false));
        return pessoaRepository.save(pessoa);
       // return pessoa;
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
