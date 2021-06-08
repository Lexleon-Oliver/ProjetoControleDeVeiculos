package com.orangetalents.cadastrodeveiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnoNaoEncontradoException extends RuntimeException {
    public AnoNaoEncontradoException() {
        super("Nenhum veículo encontrado com este ano.");
    }
}
