/**
 *
 */
package com.rising.gateway.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.http.AccessTokenRequiredException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 网关验证入口点
 *
 * @author liqiyun
 * @date 2020/08/19
 */
@Component
public class GatewayAuthenticationEntryPoint extends OAuth2AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {


		if(authException instanceof AccessTokenRequiredException) {
			System.out.println("2. udpate log to 401");
		}else {
			System.out.println("2. add log 401");
		}

		request.setAttribute("logUpdated", "yes");

		super.commence(request, response, authException);
	}

}
