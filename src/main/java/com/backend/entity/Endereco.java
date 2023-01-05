package com.backend.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private Boolean principal;

    @ManyToOne(fetch = FetchType.LAZY,  cascade= CascadeType.ALL)
    @JoinColumn(name="pessoa_id")
    private Pessoa pessoa;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco endereco)) return false;
        return id.equals(endereco.id) && logradouro.equals(endereco.logradouro) && cep.equals(endereco.cep) && numero.equals(endereco.numero) && cidade.equals(endereco.cidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, logradouro, cep, numero, cidade);
    }
}
