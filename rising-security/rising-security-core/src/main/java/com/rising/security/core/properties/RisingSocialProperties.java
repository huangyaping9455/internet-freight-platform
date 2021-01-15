package com.rising.security.core.properties;

import lombok.Data;


/**
 * @author liqiyun
 */
@Data
public class RisingSocialProperties {

    /**
     * 社交登录功能拦截的url
     */
    private String filterProcessesUrl = "/auth";

    private QQProperties qq = new QQProperties();

    private WeiXinProperties weixin = new WeiXinProperties();
}
