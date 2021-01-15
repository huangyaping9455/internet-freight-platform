package com.rising.security.core.validate.code.sms;

import com.rising.security.core.properties.RisingSecurityProperties;
import com.rising.security.core.validate.code.IValidateCode;
import com.rising.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author:liqiyun
 * @date: 2019/7/9 12:29
 * @Description: 注意验证码+ 超时时间可以进行配置
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private RisingSecurityProperties risingSecurityProperties;

    @Override
    public IValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(risingSecurityProperties.getCode().getSms().getLength());
        return new IValidateCode(code, risingSecurityProperties.getCode().getSms().getExpireIn());
    }
}
