package com.backend.repository;

import com.backend.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

    public Optional<Pessoa> findByNome(String nome);
}
