package com.leone.pay.common.exception;

/**
 * @author Leone
 * @since 2018-08-09
 **/
public class ExceptionResult {

    private Integer code;

    private String message;

    public ExceptionResult(Integer code) {
        this.code = code;
    }

    public ExceptionResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
