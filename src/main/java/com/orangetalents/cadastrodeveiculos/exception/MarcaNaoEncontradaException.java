package com.orangetalents.cadastrodeveiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Marca não encontrada.")
public class MarcaNaoEncontradaException extends Exception {
    public MarcaNaoEncontradaException() {
        super();
    }
}
