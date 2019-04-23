package com.leone.pay.common;

/**
 * @author leone
 **/
public enum ResultEnum {

    SUCCESS("success", 20000),
    WARNING("warning", 40000),
    ERROR("error", 50000);

    private String msg;

    private Integer code;

    ResultEnum() {
    }

    ResultEnum(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public ResultEnum get(ResultEnum target) {
        for (ResultEnum baseResult : ResultEnum.values()) {
            if (baseResult == target) {
                return baseResult;
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
