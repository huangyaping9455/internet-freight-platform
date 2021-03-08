
package com.rising.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * 网关安全配置
 * 资源服务适配器
 *
 * @author liqiyun
 * @date 2020/08/19
 */
@Configuration
@EnableResourceServer
public class GatewaySecurityConfig extends ResourceServerConfigurerAdapter {


    @Autowired
    private GatewayAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private GatewayAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private GatewayWebSecurityExpressionHandler gatewayWebSecurityExpressionHandler;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)
                .expressionHandler(gatewayWebSecurityExpressionHandler);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                addFilterBefore(corsFilter(), ChannelProcessingFilter.class)
                .addFilterBefore(new GatewayRateLimitFilter(), SecurityContextPersistenceFilter.class)
                .addFilterBefore(new GatewayAuditLogFilter(), ExceptionTranslationFilter.class)
                .csrf().disable()
                .authorizeRequests()
//注意哦这里添加的URL如果不生效去核心包RisingAuthorizeConfigProvider 再添加一次,应该是加载顺序导致有时间了再解决
// TODO
                .antMatchers(
                        "/uaa/code/**",
                        "/uaa/sys/organization/getInfoByOldCompanyId/**",
                        "/favicon.ico",
                        "/uaa/authentication/**",
                        "/uaa/connect/**",
                        // swagger start
                        "/**/swagger-ui.html",
                        "/**/swagger-resources/**",
                        "/**/images/**",
                        "/**/webjars/**",
                        "/**/v2/api-docs",
                        "/**/v2/api-docs",
                        "/**/configuration/ui",
                        "/**/configuration/security"
                        // swagger end


                )
                .permitAll()
                .anyRequest()
                .access("#permissionService.hasPermission(request, authentication)")
                .and()
                .headers().frameOptions().disable();
    }


    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addExposedHeader("x-auth-token");
        config.addExposedHeader("x-total-count");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
