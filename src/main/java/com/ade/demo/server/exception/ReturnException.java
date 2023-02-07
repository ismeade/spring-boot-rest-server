package com.ade.demo.server.exception;

import org.springframework.http.HttpStatus;

public class ReturnException extends IllegalArgumentException {

    protected HttpStatus httpStatus;
    protected String code;
    protected String message;

    public ReturnException(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public ReturnException(String message) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, "SYSTEM_ERROR", message);

    }

    public ReturnException() {
        this("系统内部错误");
    }

    public ReturnException(ReturnExceptionEnum returnExceptionEnum) {
        this(returnExceptionEnum.getHttpStatus(), returnExceptionEnum.getCode(), returnExceptionEnum.getMessage());
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
