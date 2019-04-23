package com.leone.pay.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.FailedLoginException;

/**
 * @author Leone
 * @since 2018-08-09
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidateException.class)
    public ExceptionResult handleBaseException(ValidateException e) {
        logger.error("{}", e.getMessage());
        return new ExceptionResult(e.getCode(), e.getMessage());
    }

//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    @ExceptionHandler(AuthorizationException.class)
//    public ExceptionResult handleAuthorizationException(Throwable e) {
//        logger.error("{}", e.getMessage());
//        return new ExceptionResult(ExceptionMessage.PERMISSION_DENIED.getCode(), ExceptionMessage.PERMISSION_DENIED.getMessage());
//    }
//
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(AuthenticationException.class)
//    public ExceptionResult handleAuthenticationException(Throwable e) {
//        logger.error("{}", e.getMessage());
//        return new ExceptionResult(40003, e.getMessage());
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FailedLoginException.class)
    public ExceptionResult handleFailedLoginException(FailedLoginException e) {
        logger.error("{}", e.getMessage());
        return new ExceptionResult(40010, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ExceptionResult handleBaseException(IllegalArgumentException e) {
        logger.error("{}", e.getMessage());
        return new ExceptionResult(40000, e.getMessage());
    }

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Throwable.class)
//    public ExceptionResult handleBaseException(Throwable e) {
//        logger.error("{}", e.getMessage());
//        return new ExceptionResult(50000, e.getMessage());
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error("{}", e.getMessage());
        return new ExceptionResult(40007, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ExceptionResult handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        logger.error("{}", e.getMessage());
        return new ExceptionResult(40005, e.getMessage());
    }

}
