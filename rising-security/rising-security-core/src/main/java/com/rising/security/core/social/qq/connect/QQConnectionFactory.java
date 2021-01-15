package com.rising.security.core.social.qq.connect;

import com.rising.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;


/**
 * 描述：组装ConnectionFactory对象---》ConnectionFactory对象由ServiceProvider和Adapter对象组成
 * 创建时间：2020-01-31 18:00:56
 * 创建作者：李启云
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    /**
     * 除了ServiceProvider和Adapter对象还需要一个providerId---》提供商的唯一标识
     *
     * @param providerId
     * @param appId
     * @param appSecret
     */
    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }
}
