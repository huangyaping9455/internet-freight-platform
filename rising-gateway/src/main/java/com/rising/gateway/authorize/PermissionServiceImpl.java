/**
 *
 */
package com.rising.gateway.authorize;


import com.rising.gateway.support.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.http.AccessTokenRequiredException;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * 描述信息：许可服务impl
 *
 * @see PermissionService#hasPermission(HttpServletRequest, Authentication)
 * 创建作者：李启云
 * 创建日期：2020-08-28
 */
@Slf4j
@Component
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    private AntPathMatcher antPathMatcher = new AntPathMatcher();


    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new AccessTokenRequiredException(null);
        }

        String principal = (String) authentication.getPrincipal();
        boolean hasPermission = false;

        //如果用户名是admin，就永远返回true
        if (StringUtils.equals(principal, "admin")) {
            hasPermission = true;
        } else {
            // 读取用户所拥有权限的所有URL
            Set<String> urls = (Set<String>) redisTemplate.opsForValue().get(principal);
            for (String url : urls) {
                log.info("请求路径{},匹配路径{}", request.getRequestURI(), url);
                if (antPathMatcher.match(url, request.getMethod().toLowerCase() + request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }
        }

        return hasPermission;

    }

}
