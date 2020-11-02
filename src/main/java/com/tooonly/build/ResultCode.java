package com.tooonly.build;

public enum ResultCode {

    SUCCESS(1,"成功")
    ,PARAM_IS_INVALID(1001,"参数无效")
    ,PARAM_IS_BLANK(1002,"参数为空")
    ,PARAM_TYPE_BIND_ERROR(1003,"参数类型错误");

    private Integer code;
    private String message;

    ResultCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }



}
