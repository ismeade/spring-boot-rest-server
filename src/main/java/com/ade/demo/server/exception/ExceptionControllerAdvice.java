package com.ade.demo.server.exception;

import com.ade.demo.server.commons.GeneralResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常错误统一消息处理类
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GeneralResult> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(GeneralResult.fail(objectError.getDefaultMessage(), ""));
    }

    /**
     * 处理自定义异常消息
     * @param e 异常
     * @return 通用返回消息
     */
    @ExceptionHandler(ReturnException.class)
    public ResponseEntity<GeneralResult> returnExceptionHandler(ReturnException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(GeneralResult.fail(e.getMessage(), null)) ;
    }

}
