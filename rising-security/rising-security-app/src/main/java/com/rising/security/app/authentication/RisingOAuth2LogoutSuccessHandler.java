package com.rising.security.app.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 描述:
 *
 * @author 李启云
 * @ProjectName master
 * @ClassName: RisingOAuth2LogoutSuccessHandler
 * @date 2020/6/4 17:04
 */

@Component
public class RisingOAuth2LogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectUri = request.getParameter("redirect_uri");
        if (!StringUtils.isEmpty(redirectUri)) {
            response.sendRedirect(redirectUri);
        }
    }
}
