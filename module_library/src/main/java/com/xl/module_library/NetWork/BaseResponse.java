package com.xl.module_library.NetWork;

/**
 * Created by wanglj on 16/7/4.
 */

public class BaseResponse<T> {

    private int code;
    private String message;
    private Boolean result;
    private T params;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                ", params=" + params +
                '}';
    }
}
