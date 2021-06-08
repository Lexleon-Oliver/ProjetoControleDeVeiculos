package com.orangetalents.cadastrodeveiculos.resouce;

import com.orangetalents.cadastrodeveiculos.dto.response.ErrorMessageResponse;
import com.orangetalents.cadastrodeveiculos.exception.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ErrorResource extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessageResponse usuarioNaoEncontrado(Exception erro, WebRequest req){
        return new ErrorMessageResponse(404,erro.getMessage(), "Usuário não encontrado","Requisição inválida");
    }

    @ExceptionHandler(MarcaNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessageResponse marcaNaoEncontrada(Exception erro, WebRequest req){
        return new ErrorMessageResponse(404,erro.getMessage(), "Marca não encontrada","Requisição inválida");
    }

    @ExceptionHandler(ModeloNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessageResponse modeloNaoEncontrado(Exception erro, WebRequest req){
        return new ErrorMessageResponse(404,erro.getMessage(), "Modelo não encontrado","Requisição inválida");
    }

    @ExceptionHandler(AnoNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessageResponse anoNaoEncontrado(Exception erro, WebRequest req){
        return new ErrorMessageResponse(404,erro.getMessage(), "Ano não encontrado","Requisição inválida");
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(400, ex.getFieldError().getDefaultMessage(), "Argumento Inválido","Requisição Inválida");
        return handleExceptionInternal(ex, errorMessageResponse, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(CPFExistenteException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageResponse cpfDuplicado(Exception erro, WebRequest req){
        return new ErrorMessageResponse(400,erro.getLocalizedMessage(), "CPF já cadastrado","Requisição inválida");
    }

    @ExceptionHandler(EmailExistenteException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageResponse emailDuplicado(Exception erro, WebRequest req){
        return new ErrorMessageResponse(400,erro.getLocalizedMessage(), "E-mail já cadastrado!","Requisição inválida");
    }
}
