package com.atguigu.common;

public enum ResultCodeEnum {
    SUCCESS(200, "SUCCESS"),
    LOGIN_SUCCESS(501, "login_success"),
    LOGIN_PWD_FAIL(502, "LoginPWDFAIL"),
    LOGIN_USER_NAME_FAIL(503, "LoginUserNameFail"),
    REGISTER_SUCCESSL(504, "registerSuccessl"),
    REGISTER_EXISTED_FAIL(505, "register_existed_fail"),
    NOT_LOGIN(506, "notlogin");
    private int code;
    private String message;


    private ResultCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
