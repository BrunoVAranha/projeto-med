package com.projeto.farma.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Document(collection = "users")
public class User {

    @Id
    private String id;

    @Size(min = 2, max = 20, message = "Tamanho invalido para o campo nome")
    @NotNull
    @NotBlank(message = "Este campo nao pode estar vazio")
    private String nome;

    @Size(min = 5, max = 50, message = "Tamanho invalido para o campo sobrenome")
    @NotNull
    @NotBlank(message = "Este campo nao pode estar vazio")
    private String sobrenome;

    @Size(min = 11, max = 11, message = "Tamanho invalido para o campo cpf")
    @NotNull
    @NotBlank(message = "Este campo nao pode estar vazio")
    private String cpf;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
