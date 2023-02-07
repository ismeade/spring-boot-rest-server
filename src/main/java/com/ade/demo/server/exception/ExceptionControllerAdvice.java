package com.ade.demo.server.exception;

import com.ade.demo.server.commons.GeneralResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GeneralResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return GeneralResult.fail(objectError.getDefaultMessage(), "");
    }

    @ExceptionHandler(ReturnException.class)
    public GeneralResult returnExceptionHandler(ReturnException e) {
        return GeneralResult.fail(e.getMessage(), null);
    }

}
