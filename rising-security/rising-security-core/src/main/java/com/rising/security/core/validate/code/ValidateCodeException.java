package com.rising.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * 描述：继承spring-security异常类的基类
 * 创建时间：2020-01-31 12:02:37
 * 创建作者：李启云
 */
public class ValidateCodeException extends AuthenticationException {
    private static final long serialVersionUID = -75098325592950112L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
