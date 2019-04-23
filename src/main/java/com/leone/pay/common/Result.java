package com.leone.pay.common;

import com.leone.pay.common.exception.ExceptionMessage;

import java.io.Serializable;

/**
 * <p>
 *
 * @author leone
 **/
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1813924894386442775L;

    private String messages;

    private Integer code;

    private T data;

    private Result() {
    }

    private Result(String messages, Integer code, T data) {
        this.messages = messages;
        this.code = code;
        this.data = data;
    }

    private Result(ExceptionMessage exceptionMessage, T data) {
        this.messages = exceptionMessage.getMessage();
        this.code = exceptionMessage.getCode();
        this.data = data;
    }

    private Result(String messages, Integer code) {
        this.messages = messages;
        this.code = code;
    }

    public static <T> Result<T> build(String message, Integer code, T data) {
        return new Result<>(message, code, data);
    }

    public static <T> Result<T> error(String message, Integer code) {
        return new Result<>(message, code, null);
    }

    public static <T> Result<T> error(ExceptionMessage exceptionMessage) {
        return new Result<>(exceptionMessage, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ExceptionMessage.SUCCESS, data);
    }

    public static <T> Result<T> success(String messages) {
        return new Result<>(messages, 20000);
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
