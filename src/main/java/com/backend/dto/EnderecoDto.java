package com.backend.dto;

public class EnderecoDto {


    private String logradouro;
    private String cep;
    private String numero;
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
