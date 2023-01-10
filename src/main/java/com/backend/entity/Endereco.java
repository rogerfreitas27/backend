package com.backend.entity;

import com.backend.dto.EnderecoDto;
import com.backend.dto.PessoaDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.Objects;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message="Campo Obrigatório")
    @Size(min = 3, max=255,message="campo com no mínimo 3 e no máximo de 255 caracteres.")
    private String logradouro;
    @NotBlank(message="Campo Obrigatório")
    @Size(min = 8, max=8,message="campo com no mínimo 8 e no máximo de 8 caracteres.")
    @Pattern(regexp = "^[0-9]+$", message="Apenas numeros")
    private String cep;
    private String numero;
    @NotBlank(message="Campo Obrigatório")
    @Size(min = 3, max=255,message="campo com no mínimo 3 e no máximo de 255 caracteres.")
    private String cidade;

    @JsonIgnore
    private Boolean principal;

    @ManyToOne(cascade =CascadeType.MERGE)
    @JsonIgnore
    private Pessoa pessoa;

    public Endereco(){}
    private Endereco(Builder builder) {
        this.id = builder.id;
        this.logradouro = builder.logradouro;
        this.cep = builder.cep;
        this.numero = builder.numero;
        this.cidade= builder.cidade;
        this.principal = builder.principal;
        this.pessoa = builder.pessoa;

    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro=" + logradouro  +
                ", cep=" + cep  +
                ", numero=" + numero  +
                ", cidade=" + cidade  +
                ", principal=" + principal +
                '}';
    }

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
        return id.equals(endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public static class Builder {

        private Long id;
        private String logradouro;
        private String cep;
        private String numero;
        private String cidade;

        private Boolean principal;


        private Pessoa pessoa;

        public Builder (){

        }

        public Builder logradouro(String logradouro) {
            this.logradouro = logradouro;
            return this;
        }


        public Builder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public Builder numero(String numero) {
            this.numero = numero;
            return this;
        }

        public Builder cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public Builder principal(Boolean principal) {
            this.principal = principal;
            return this;
        }

        public Builder pessoa(Pessoa pessoa) {
            this.pessoa = pessoa;
            return this;
        }

        public Endereco build() {
            return new Endereco(this);
        }
    }
}
