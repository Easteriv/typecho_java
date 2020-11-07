package com.github.typecho_java.constant;

/**
 * @author zhaojiejun
 * @version V1.0
 * @date 2020/6/7 12:59 上午
 * @description 自定义错误码
 **/
public enum ErrorCodeEnum {
    /**
     * 系统异常
     */
    RESULT_OK("00000","success"),
    SYS_ERROR("00001","system is error"),

    /**
     * 业务异常
     */
    VALIDATE_FALSE("A0100", "check not pass,the param may be error"),
    PAGE_SIZE_ERROR("A0101","pageSize or pageNum should rather than 0"),
    PARAM_NULL("A0102","the param is null"),
    CATEGORY_NOT_FOUND("A0103","the categoryId is not present");

    private final String errorCode;
    private final String errorMsg;

    ErrorCodeEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
