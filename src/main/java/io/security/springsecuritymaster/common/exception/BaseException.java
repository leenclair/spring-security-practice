package io.security.springsecuritymaster.common.exception;

import io.security.springsecuritymaster.common.response.ErrorCode;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{

    private ErrorCode errorCode;

    public BaseException(){}

    public BaseException(ErrorCode errorCode){
        super(errorCode.getErrorMsg());
        this.errorCode = errorCode;
    }

    public BaseException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public BaseException(String message, ErrorCode errorCode, Throwable cause){
        super(message, cause);
        this.errorCode = errorCode;
    }
}