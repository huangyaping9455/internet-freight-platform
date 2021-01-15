package com.rising.gateway.security;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 描述：网关速率限制滤波器
 *
 * @see OncePerRequestFilter
 * 作者：李启云
 * 日期：2020-12-01
 */
public class GatewayRateLimitFilter extends OncePerRequestFilter {

	private RateLimiter rateLimiter = RateLimiter.create(2);


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		System.out.println("0 rate limit ");

		if(rateLimiter.tryAcquire()) {
			filterChain.doFilter(request, response);
		}else {
			response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("{\"error\":\"请求太快\"}");
			response.getWriter().flush();
			return;
		}
	}

}
