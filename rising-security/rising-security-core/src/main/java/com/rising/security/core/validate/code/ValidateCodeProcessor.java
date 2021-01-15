package com.rising.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 描述：校验码处理器，封装不同校验码的处理逻辑
 * 创建时间：2020-01-31 12:00:38
 * 创建作者：李启云
 */
public interface ValidateCodeProcessor {
    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     *
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param servletWebRequest
     * @throws Exception
     */
    void validate(ServletWebRequest servletWebRequest);
}
