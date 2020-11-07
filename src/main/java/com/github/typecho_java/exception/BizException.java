package com.github.typecho_java.exception;

import com.github.typecho_java.constant.ErrorCodeEnum;

/**
 * @author zhaojiejun
 * @date 2020/8/23 7:32 下午
 **/
public class BizException extends RuntimeException{
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BizException(ErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrorMsg());
        this.code = errorCodeEnum.getErrorCode();
    }

}
