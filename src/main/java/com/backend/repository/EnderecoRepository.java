package com.backend.repository;


import com.backend.entity.Endereco;
import com.backend.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {


    public Set<Endereco>findEnderecoByPessoa(Long id);
}
