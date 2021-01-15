/**
 *
 */
package com.rising.rbac.service.impl;

import com.rising.rbac.domain.Admin;
import com.rising.security.core.authorize.PermissionService;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;


/**
 *
 * @author liqiyun
 */
@Component("permissionService")
public class RbacServiceImpl implements PermissionService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();

        boolean hasPermission = false;
		if (principal instanceof Admin) {
			String username = ((UserDetails) principal).getUsername();
			//如果用户名是admin，就永远返回true
			if (StringUtils.equals(username, "admin")) {
				hasPermission = true;
			} else {
				// 读取用户所拥有权限的所有URL
				Set<String> urls = ((Admin) principal).getUrls();
				for (String url : urls) {
					if (antPathMatcher.match(url, request.getRequestURI())) {
						hasPermission = true;
						break;
					}
				}
			}
		}

		return hasPermission;

    }

}
