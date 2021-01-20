package com.nxyf.springcloud.enums;

public enum ResultCode {


    SUCCESS(20000, "成功"),
    FAIL(4000,"失败");

    public Integer code;

    public String message;

    private ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
