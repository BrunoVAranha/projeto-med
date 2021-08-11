package com.projeto.farma.exception;

public class CpfJaExisteException extends Exception{

    public CpfJaExisteException(){
        super("Este cpf já está cadastrado.");
    }
}
