///**
// *
// */
//package com.rising.rbac.authorize;
//
//import com.rising.security.core.authorize.AuthorizeConfigProvider;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
//import org.springframework.stereotype.Component;
//
//
///**
// * 授权
// *
// * @author liqiyun
// */
//@Component
//@Order(Integer.MIN_VALUE)
//public class RbacAuthorizeConfigProvider implements AuthorizeConfigProvider {
//
//    /**
//     * @see AuthorizeConfigProvider#config(org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry)
//     */
//    @Override
//    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
//        config
//                .antMatchers(HttpMethod.GET, "/fonts/**").permitAll()
//                .antMatchers(HttpMethod.GET,
//                        "/**/*.html",
//                        "/admin/me*",
//                        "/resource/**").authenticated()
//                .anyRequest()
//                .access("@permissionService.hasPermission(request, authentication)");
//        return true;
//    }
//
//}
