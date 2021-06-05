package com.orangetalents.cadastrodeveiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Nenhum veículo encontrado com este ano.")
public class AnoNaoEncontradoException extends Exception {
    public AnoNaoEncontradoException() {
        super();
    }
}
