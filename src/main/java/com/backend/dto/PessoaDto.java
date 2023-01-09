package com.backend.dto;

import com.backend.entity.Endereco;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

public class PessoaDto {


    @NotBlank(message="Campo Obrigatório")
    @Size(min = 3, max=255,message="campo com no mínimo 3 e no máximo de 255 caracteres.")
    private String nome;
    private LocalDate nascimento;

    private Set<EnderecoDto> enderecosDto;


    public PessoaDto() {
    }

    public PessoaDto(String nome, LocalDate nascimento, Set<EnderecoDto> enderecosDto) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.enderecosDto = enderecosDto;
    }


    @Override
    public String toString() {
        return "PessoaDto{" +
                "nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", enderecosDto=" + enderecosDto +
                '}';
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

    public Set<EnderecoDto> getEnderecosDto() {
        return enderecosDto;
    }

    public void setEnderecosDto(Set<EnderecoDto> enderecosDto) {
        this.enderecosDto = enderecosDto;
    }
}
