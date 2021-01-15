package com.rising.security.app.processor;

import com.rising.security.core.authorize.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

/**
 * 上升oauth2网络安全表达式处理程序
 * 描述:
 *
 * @author 李启云
 * @ProjectName master
 * @ClassName: RisingOAuth2WebSecurityExpressionHandler
 * @date 2020/5/24 09:10
 */
@Component
public class RisingOAuth2WebSecurityExpressionHandler extends OAuth2WebSecurityExpressionHandler {

    @Autowired
    private PermissionService permissionService;

    @Override
    protected StandardEvaluationContext createEvaluationContextInternal(Authentication authentication, FilterInvocation invocation) {
        StandardEvaluationContext evaluationContextInternal = super.createEvaluationContextInternal(authentication, invocation);
        evaluationContextInternal.setVariable("permissionService", permissionService);
        return evaluationContextInternal;

    }
}
