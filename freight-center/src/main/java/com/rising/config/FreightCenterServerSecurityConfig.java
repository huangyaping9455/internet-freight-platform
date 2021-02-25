

package com.rising.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


/**
 * 描述：货运中心服务器安全配置
 *
 * @see ResourceServerConfigurerAdapter
 * 作者：李启云
 * 日期：2021-01-18
 */

@Configuration
public class FreightCenterServerSecurityConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
				.antMatchers(

						// swagger start
						"/**/swagger-ui.html",
						"/**/swagger-resources/**",
						"/**/images/**",
						"/**/webjars/**",
						"/**/v2/api-docs",
						"/**/api-docs",
						"/**/configuration/ui",
						"/**/configuration/security"
						// swagger end


				).permitAll()
                .requestMatchers(EndpointRequest.toAnyEndpoint())
                .permitAll()
                .anyRequest().authenticated();
    }
}

