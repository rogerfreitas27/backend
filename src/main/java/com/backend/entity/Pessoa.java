package com.backend.entity;

import com.backend.dto.PessoaDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.*;


@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message="Campo Obrigatório")
    @Size(min = 3, max=255,message="campo com no mínimo 3 e no máximo de 255 caracteres.")
    private String nome;
    private LocalDate nascimento;
    @OneToMany(mappedBy = "pessoa", cascade=CascadeType.MERGE)
    @JsonProperty("enderecos")
    private Set<Endereco> enderecos;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, LocalDate nascimento) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
    }



    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome=" + nome +
                ", nascimento=" + nascimento +
                ", enderecos=" + enderecos +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }


   @JsonIgnore
   public Set<Endereco> getEndereco() {
        return enderecos;
    }

    public void addEndereco(Endereco endereco) {
        if(this.enderecos == null)
                 this.enderecos = new HashSet<>();
        this.enderecos.add(endereco);
    }


    public Pessoa convertDtoToPessoa(PessoaDto pessoaDto){
        Pessoa pessoa = new Pessoa(null,pessoaDto.getNome(),pessoaDto.getNascimento());
        return pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return id.equals(pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
