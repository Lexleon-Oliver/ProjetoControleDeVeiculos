package com.orangetalents.cadastrodeveiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModeloNaoEncontradoException extends RuntimeException {
    public ModeloNaoEncontradoException() {
        super("Modelo não encontrado.");
    }
}
