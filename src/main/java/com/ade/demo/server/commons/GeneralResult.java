package com.ade.demo.server.commons;

import java.io.Serializable;

public class GeneralResult implements Serializable {

    private String code;
    private String message;
    private Object data;

    public GeneralResult(String code, String message, Object data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    public static GeneralResult success() {
        return new GeneralResult("SUCCESS", "", null);
    }

    public static GeneralResult success(Object data) {
        return new GeneralResult("SUCCESS", "", data);
    }

    public static GeneralResult success(String message, Object data) {
        return new GeneralResult("SUCCESS", message, data);
    }

    public static GeneralResult fail(String message) {
        return new GeneralResult("FAIL", message, null);
    }

    public static GeneralResult fail(String message, Object data) {
        return new GeneralResult("FAIL", message, data);
    }

    public String getCode() {
        return code;
    }

    public GeneralResult setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public GeneralResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public GeneralResult setData(Object data) {
        this.data = data;
        return this;
    }
}
