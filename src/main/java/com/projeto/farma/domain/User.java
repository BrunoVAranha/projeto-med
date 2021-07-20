package com.projeto.farma.domain;

import com.projeto.farma.adapter.Medico;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection = "users")
@Getter @Setter
public class User extends Medico {

    @Id
    private String profileId;

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

    @Size(min = 2, max = 20, message = "Tamanho invalido para o campo departamento")
    @NotNull
    @NotBlank(message = "Este campo nao pode estar vazio")
    private String departamento;
}
