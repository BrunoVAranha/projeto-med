package com.projeto.farma.exception.handler;

import com.projeto.farma.exception.CpfJaExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ExceptionHandlerGlobal {
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(CpfJaExisteException.class)
    public ResponseEntity<String> handleConflict() {
        return ResponseEntity.status(406).body("Usuario nao foi salvo. \nCausa: CPF ja cadastrado.");
    }
}