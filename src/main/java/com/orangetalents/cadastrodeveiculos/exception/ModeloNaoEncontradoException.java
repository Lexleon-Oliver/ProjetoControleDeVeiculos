package com.orangetalents.cadastrodeveiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Modelo não encontrado.")
public class ModeloNaoEncontradoException extends Exception {
    public ModeloNaoEncontradoException() {
        super();
    }
}
