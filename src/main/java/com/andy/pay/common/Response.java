package com.andy.pay.common;


import java.io.Serializable;

/**
 * <p>
 *
 * @author Leone
 **/
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 4872071210789222850L;

    private Integer code;

    private String message;

    private T data;

    private Response() {
    }

    private Response(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> build(Integer code, String message, T data) {
        return new Response<>(code, message, data);
    }

    public static <T> Response<T> build(ResultEnum resultEnum) {
        return new Response<>(resultEnum.getCode(), resultEnum.getMsg(), null);
    }

    public static <T> Response<T> error(String message) {
        return new Response<>(40000, message, null);
    }

    public static <T> Response<T> error(Integer code, String message) {
        return new Response<>(code, message, null);
    }

    public static <T> Response<T> success(String message) {
        return new Response<>(20000, message, null);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(20000, "success", data);
    }

    public static <T> Response<T> build(Integer code, String msg) {
        return new Response<>(code, msg, null);
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
