package com.example.MiniProjeto.exceptions;

import com.example.MiniProjeto.exceptions.dtos.ErroResponse;
import com.example.MiniProjeto.exceptions.exceptionsPersonalizadas.FiltrosException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroResponse> trataEntidadeNaoEncontrada(EntityNotFoundException exception) {
        ErroResponse erro = new ErroResponse();

        erro.setCampo("ID");
        erro.setMensagem(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ErroResponse> trataChaveDuplicada(DuplicateKeyException exception) {
        ErroResponse erro = new ErroResponse();

        erro.setCampo(("CRM"));
        erro.setMensagem(exception.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResponse> trataEnumInvalido(HttpMessageNotReadableException exception) {
        ErroResponse response = new ErroResponse();
        response.setCampo("Especialidade");
        response.setMensagem(exception.getLocalizedMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(FiltrosException.class)
    public ResponseEntity<ErroResponse> trataFiltros(FiltrosException exception) {
        ErroResponse erro = new ErroResponse();

        erro.setCampo("Filtros");
        erro.setMensagem(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
