package com.backend.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class EnderecoDto {

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


    public EnderecoDto() {
    }

    public EnderecoDto(String logradouro, String cep, String numero, String cidade) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "EnderecoDto{" +
                "logradouro='" + logradouro + '\'' +
                ", cep='" + cep + '\'' +
                ", numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
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



}
