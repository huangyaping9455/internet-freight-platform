package com.rising.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * @author : 李启云
 * @date : 2019/10/22 0:14
 * Description：指定springsocial成功处理器的接口
 */
public interface SocialAuthenticationFilterPostProcessor {

    /**
     * 参数为springsocial的过滤器
     * @param socialAuthenticationFilter
     */
    void process(SocialAuthenticationFilter socialAuthenticationFilter);
}
