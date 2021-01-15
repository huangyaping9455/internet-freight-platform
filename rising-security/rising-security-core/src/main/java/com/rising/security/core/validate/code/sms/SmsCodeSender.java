package com.rising.security.core.validate.code.sms;


/**
 * 描述：短信发送接口 ----  不同供应商可能不同
 * 创建时间：2020-01-31 11:27:59
 * 创建作者：李启云
 */
public interface SmsCodeSender {

    /**
     * 向手机发送短信验证码
     *
     * @param mobile
     * @param code
     */
    void send(String mobile, String code);
}
