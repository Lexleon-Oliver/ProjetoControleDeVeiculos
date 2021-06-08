package com.orangetalents.cadastrodeveiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CPFExistenteException extends RuntimeException{
    public CPFExistenteException(){
        super("O CPF é obrigatório e deve ser único");
    }
}
