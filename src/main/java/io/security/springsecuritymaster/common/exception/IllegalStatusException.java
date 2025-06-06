package io.security.springsecuritymaster.common.exception;

import io.security.springsecuritymaster.common.response.ErrorCode;

public class IllegalStatusException extends BaseException{

    public IllegalStatusException(){
        super(ErrorCode.COMMON_ILLEGAL_STATUS);
    }

    public IllegalStatusException(String message){
        super(message, ErrorCode.COMMON_ILLEGAL_STATUS);
    }
}