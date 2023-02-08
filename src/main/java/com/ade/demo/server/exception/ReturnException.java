package com.ade.demo.server.exception;

import org.springframework.http.HttpStatus;

/**
 * 自定义异常
 */
public class ReturnException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public static final ReturnException SORT_ERROR_NOT_SUPPORTED_DATA_FORMAT =
            new ReturnException(
                    HttpStatus.BAD_REQUEST,
                    "SORT_ERROR_NOT_SUPPORTED_DATA_FORMAT",
                    "不支持该数据类型排序");
    public static final ReturnException SORT_ERROR_NOT_SUPPORTED_HETEROGENEOUS_DATA =
            new ReturnException(
                    HttpStatus.BAD_REQUEST,
                    "SORT_ERROR_NOT_SUPPORTED_HETEROGENEOUS_DATA",
                    "不支持不同数据类型排序");

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
