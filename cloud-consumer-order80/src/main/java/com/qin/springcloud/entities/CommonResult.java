package com.qin.springcloud.entities;

import java.io.Serializable;

/**
 * description
 *
 * @author qcb
 * @date 2021/11/12 16:41.
 */
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 11241704910499845L;

    private Integer code;

    private String message;

    private T data;

    public CommonResult(){

    }

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
