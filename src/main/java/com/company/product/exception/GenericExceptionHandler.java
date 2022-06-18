package com.company.product.exception;

import com.company.product.payload.response.ExceptionResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ResponseBody
@ControllerAdvice
public class GenericExceptionHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    protected ExceptionResponse handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        return new ExceptionResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "No entity with given id exists!", "");
    }

}
