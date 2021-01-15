package com.rising.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 描述：以后还会有别的验证码生成逻辑，故将其统一定义出来
 * 创建时间：2020-01-31 11:53:55
 * 创建作者：李启云
 */
public interface ValidateCodeGenerator {
    /**
     * 生成验证码
     *
     * @param request
     * @return
     */
    IValidateCode generate(ServletWebRequest request);
}
