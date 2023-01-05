package com.backend.service;


import com.backend.entity.Endereco;
import com.backend.entity.Pessoa;
import com.backend.exception.ObjectNotFoundException;
import com.backend.repository.EnderecoRepository;
import com.backend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;

    public Endereco save(Endereco endereco){
        pessoaService.findById(endereco.getPessoa().getId());
        return enderecoRepository.save(endereco);
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
              return save(endereco);

        enderecos.add(endereco);
        enderecoRepository.saveAll(enderecos);
        return endereco;
    }

    public Set<Endereco> findEnderecoByPessoa(Long id){
        return enderecoRepository.findEnderecoByPessoa(id);
    }


    public Endereco findById(Long id){
        return enderecoRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Endereco não encontrado"));
    }
}
