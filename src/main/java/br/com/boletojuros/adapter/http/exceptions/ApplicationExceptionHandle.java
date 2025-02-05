package br.com.boletojuros.adapter.http.exceptions;

import br.com.boletojuros.core.domain.enums.TipoExcecao;
import br.com.boletojuros.core.exceptions.ApplicationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApplicationExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> applicationException(ApplicationException ex, WebRequest request) {
        var response = ErrorResponse.builder()
                .mensagens(Arrays.asList(ex.getTipoExcecao().getMensagemErro()))
                .erro(ex.getTipoExcecao().toString().toLowerCase())
                .codigo(HttpStatus.BAD_REQUEST.value())
                .timestamp(new Date())
                .path(request.getDescription(false))
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var erros = e.getFieldErrors().stream()
                .map(item -> item.getField() + " " + item.getDefaultMessage())
                .collect(Collectors.toList());

        var response = ErrorResponse.builder()
                .mensagens(erros)
                .erro(TipoExcecao.CONTEUDO_INVALIDO.toString().toLowerCase())
                .timestamp(new Date())
                .codigo(HttpStatus.BAD_REQUEST.value())
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
