package com.rising.security.app.config;

import com.rising.security.app.processor.RisingOAuth2WebSecurityExpressionHandler;
import com.rising.security.app.social.openid.OpenIdAuthenticationSecurityConfig;
import com.rising.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.rising.security.core.authorize.AuthorizeConfigManager;
import com.rising.security.core.enums.SecurityConstants;
import com.rising.security.core.social.SocialConfig;
import com.rising.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;


/**
 * 描述： 资源服务器
 * 创建时间：2020-02-01 23:02:33
 * 创建作者：李启云
 *
 * @author liqiyun
 */
@Configuration
@EnableResourceServer
public class RisingResourcesServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    /**
     * openId校验配置类
     */
    @Autowired
    private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

    /**
     * @see SocialConfig#risingSocialSecurityConfig()
     */
    @Autowired
    private SpringSocialConfigurer springSocialConfigurer;

    /**
     * 资源认证管理器
     */
    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Autowired
    private RisingOAuth2WebSecurityExpressionHandler risingOAuth2WebSecurityExpressionHandler;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and().logout()
                .logoutSuccessHandler(logoutSuccessHandler)
        ;

        //将验证码校验逻辑放开
        http.apply(validateCodeSecurityConfig)

                //验证码配置
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                //社交登录配置
                .and()
                .apply(springSocialConfigurer)
                .and()
                .apply(openIdAuthenticationSecurityConfig)
                /*
                 此段权限验证移交给不同的的应用写对应的权限信息去实现<AuthorizeConfigManager>资源认证管理器
                 .and()
                     .authorizeRequests()
                      .antMatchers(
                           SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                           SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                           SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_OPENID,
                           risingSecurityProperties.getBrowser().getLoginPage(),
                           SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                           risingSecurityProperties.getBrowser().getSignUpUrl(),
                           risingSecurityProperties.getBrowser().getSession().getSessionInvalidUrl(),
                           risingSecurityProperties.getBrowser().getSignOutUrl(),
                           "/user/register", "/social/signUp")
                   .permitAll()
                   .anyRequest()
                   .authenticated()*/
                .and()
                .csrf().disable();
        authorizeConfigManager.config(http.authorizeRequests());
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.expressionHandler(risingOAuth2WebSecurityExpressionHandler);
    }
}
