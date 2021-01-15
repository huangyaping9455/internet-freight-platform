package com.rising.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;


/**
 * 描述：保存、获取、移除验证码的模版接口
 * 创建时间：2020-01-31 12:01:14
 * 创建作者：李启云
 */
public interface ValidateCodeRepository {
    /**
     * 保存验证码
     * @param request
     * @param code
     * @param validateCodeType
     */
    void save(ServletWebRequest request, IValidateCode code, ValidateCodeType validateCodeType);
    /**
     * 获取验证码
     * @param request
     * @param validateCodeType
     * @return
     */
    IValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType);
    /**
     * 移除验证码
     * @param request
     * @param codeType
     */
    void remove(ServletWebRequest request, ValidateCodeType codeType);
}
