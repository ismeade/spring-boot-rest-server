package com.ade.demo.server.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Configuration
public class ReturnExceptionResolver implements HandlerExceptionResolver {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        log.error("{} - {}", httpServletRequest.getMethod(), httpServletRequest.getRequestURI());
        return def(e);
    }

    private ModelAndView def(Exception e) {
        log.info(e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        if (e instanceof ReturnException) {
            ReturnException returnException = (ReturnException) e;
            modelAndView.setStatus(returnException.getHttpStatus());
            modelAndView.addObject("code", returnException.getCode());
            modelAndView.addObject("message", returnException.getMessage());
        } else {
            modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            modelAndView.addObject("code", "INTERNAL_SERVER_ERROR");
            modelAndView.addObject("message", "系统内部错误");
        }
        return modelAndView;
    }

}
