package com.rising.security.core.authorize;

import com.rising.security.core.enums.SecurityConstants;
import com.rising.security.core.properties.RisingSecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * 描述:核心模块的授权配置提供器，安全模块涉及的url的授权配置在这里
 *
 * @author 李启云
 * @ProjectName risingdog
 * @ClassName: RisingAuthorizeConfigProvider
 * @date 2020/4/18 20:56
 */

@Component
@Order(Integer.MIN_VALUE)
public class RisingAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Autowired
    private RisingSecurityProperties risingSecurityProperties;

    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                //手机验证码登录的url
                SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                //openid登录请求url
                SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_OPENID,
                //默认处理验证码的url前缀
                SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                //默认登录页面
                risingSecurityProperties.getBrowser().getLoginPage(),
                //社交登录，如果需要用户注册，跳转的页面
                risingSecurityProperties.getBrowser().getSignUpUrl(),
                "/sys/organization/getInfoByOldCompanyId/*",
                //session失效时跳转的地址
                risingSecurityProperties.getBrowser().getSession().getSessionInvalidUrl())
                .permitAll();
        if (StringUtils.isNotBlank(risingSecurityProperties.getBrowser().getSignOutUrl())) {
            config.antMatchers(risingSecurityProperties.getBrowser().getSignOutUrl()).permitAll();
        }
        return false;
    }
}
