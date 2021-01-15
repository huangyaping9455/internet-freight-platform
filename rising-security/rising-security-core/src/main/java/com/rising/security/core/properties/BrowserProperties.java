package com.rising.security.core.properties;

import com.rising.security.core.enums.LoginType;
import com.rising.security.core.enums.SecurityConstants;
import lombok.Data;


/**
 * @author liqiyun
 */
@Data
public class BrowserProperties {

    /**社交登录，如果需要用户注册，跳转的页面*/
    private String signUpUrl = SecurityConstants.DEFAULT_SIGNUP_URL;

    /**指定默认的登陆页面*/
    private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

    /**指定默认的处理成功与处理失败的方法*/
    private LoginType loginType = LoginType.JSON;

    /**记住我的时间3600秒即1小时*/
    private int rememberMeSeconds = 3600;

    /**session相关的配置如session最大并发数量等*/
    private SessionProperties session = new SessionProperties();

    /**退出登陆需要的url，默认为null*/
    private String signOutUrl = "/";
    /**
     * 登录成功后跳转的地址，如果设置了此属性，则登录成功后总是会跳到这个地址上。
     * 只在signInResponseType为REDIRECT时生效
     */
    private String loginSuccessUrl;


}
