/**
 *
 */
package com.rising.gateway.security;

import com.alibaba.fastjson.JSON;
import com.rising.security.core.enums.ResultEnum;
import com.rising.security.core.utils.ResultVOUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 网关访问被拒绝处理程序
 *
 * @author meet
 * @date 2020/08/19
 */
@Component
public class GatewayAccessDeniedHandler extends OAuth2AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException)
			throws IOException, ServletException {

		System.out.println("2. update log to 403");

		request.setAttribute("logUpdated", "yes");
		//修改状态码
		response.setStatus(HttpStatus.FORBIDDEN.value());
		//设置返回内容的数据形式和编码格式
		response.setContentType("application/json;charset=UTF-8");
		//将抓到的错误信息以json数据的形式进行返回
		response.getWriter().write(JSON.toJSONString
				(ResultVOUtil.error(ResultEnum.FORBIDDEN.getCode(), ResultEnum.FORBIDDEN.getMessage())));
		//super.handle(request, response, authException);
	}

}
