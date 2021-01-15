

package com.rising.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


/**
 * 描述信息：安全配置
 *
 * @see ResourceServerConfigurerAdapter
 * 创建作者：李启云
 * 创建日期：2020-08-28
 */

@Configuration
public class ActuatorSecurityConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
			.anyRequest().authenticated();
	}
}

