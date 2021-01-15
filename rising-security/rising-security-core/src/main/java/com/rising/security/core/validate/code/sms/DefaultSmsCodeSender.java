package com.rising.security.core.validate.code.sms;


/**
 * 描述：注意SmsCodeSender为定义的“将生成的验证码通过手机号发给用户”的接口
 * 开发者应该继承该接口，然后根据具体供应商即联通、移动、电信等完成发送短信功能的具体实现，
 * 而本类为一个超级简单的实现，并没有向用户发送短信功能，只是向控制台输出一句话
 * 创建时间：2020-01-31 11:24:29
 * 创建作者：李启云
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机" + mobile + "发送短信验证码" + code);
    }
}
