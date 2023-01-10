package com.backend.service;

import com.backend.entity.Endereco;
import com.backend.entity.Pessoa;
import com.backend.exception.ObjectNotFoundException;
import com.backend.repository.EnderecoRepository;
import com.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Endereco save(Long idPessoa,Endereco endereco){
        Pessoa pessoa = new Pessoa();
        pessoa = pessoaRepository.findById(idPessoa).orElseThrow(() ->
                new ObjectNotFoundException("Pessoa não encontrada"));

        Endereco end = new Endereco.Builder()
                      .logradouro(endereco.getLogradouro())
                      .cep(endereco.getCep())
                      .numero(endereco.getNumero())
                      .principal(false)
                      .cidade(endereco.getCidade())
                      .pessoa(pessoa)
                      .build();

        return enderecoRepository.save(end);
    }

    public void saveAll(Set<Endereco> Enderecos){
       Set<Endereco> enderecos = new HashSet<>(enderecoRepository.saveAll(Enderecos));
    }

    public List<Endereco> enderecos(){
        return enderecoRepository.findAll();
    }

    public Endereco update(Long id){
        Endereco endereco = new Endereco();
        endereco = findById(id);
        Set<Endereco> enderecos = new HashSet<>();
        enderecos = enderecoRepository.findEnderecoByPessoa(endereco.getPessoa().getId());
        enderecos.stream().filter(e-> e.getPrincipal() == true).forEach(e->e.setPrincipal(false));
        endereco.setPrincipal(true);
        if(endereco.getPessoa().getId()==null)
              return enderecoRepository.save(endereco);

        enderecos.add(endereco);
        enderecoRepository.saveAll(enderecos);
        return endereco;
    }

    public Set<Endereco> findEnderecoByPessoa(Long id){
        pessoaRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Pessoa não encontrada"));
        return enderecoRepository.findEnderecoByPessoa(id);
    }


    public Endereco findById(Long id){
        return enderecoRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Endereco não encontrado"));
    }
}
