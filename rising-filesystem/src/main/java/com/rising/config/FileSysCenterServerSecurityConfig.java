

package com.rising.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


/**
 * 描述：文件系统中心服务器安全配置
 *
 * @see ResourceServerConfigurerAdapter
 * 作者：李启云
 * 日期：2021-01-18
 */

@Configuration
public class FileSysCenterServerSecurityConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
			.anyRequest().authenticated();
	}
}

