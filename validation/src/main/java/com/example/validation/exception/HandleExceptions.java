package com.example.validation.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandleExceptions {

    @ExceptionHandler
    @ResponseBody
    public ErrorResponseMessage handleMethodException(HttpServletRequest request, Exception exception) {

        if (exception.getMessage() == null) {
            return new ErrorResponseMessage(request.getMethod(), "Your request does not contain any data.", System.currentTimeMillis());
        }
        return new ErrorResponseMessage(request.getMethod(), exception.getMessage(), System.currentTimeMillis());

    }

}
