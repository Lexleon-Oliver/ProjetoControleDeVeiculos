package com.orangetalents.cadastrodeveiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailExistenteException extends RuntimeException{
    public EmailExistenteException(){
        super("O e-mail é obrigatório e deve ser único");
    }
}
