package com.rising.security.core.social.weixin.connect;

import com.rising.security.core.social.weixin.api.WeiXin;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.support.OAuth2Connection;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

/**
 * 描述：微信连接工厂
 *
 * @see OAuth2ConnectionFactory
 * 作者：李启云
 * 日期：2020-09-29
 */
public class WeiXinConnectionFactory extends OAuth2ConnectionFactory<WeiXin> {

    public WeiXinConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new WeiXinServiceProvider(appId, appSecret), new WeiXinAdapter());
    }


    /**
     * 创建：李启云
     * 日期：2020-09-29
     * 描述：创建连接
     * 获取用户在微信的用户信息并将其封装成Connection对象
     * 在此之前已经拿到了accessToken 和 openIdextract(即providerUserId)等信息
     *
     * @param accessGrant 访问授权
     * @return {@link Connection<WeiXin> }
     */
    @Override
    public Connection<WeiXin> createConnection(AccessGrant accessGrant) {
        return new OAuth2Connection<>(getProviderId(),
                extractProviderUserId(accessGrant),
                accessGrant.getAccessToken(),
                accessGrant.getRefreshToken(),
                accessGrant.getExpireTime(),
                getOAuth2ServiceProvider(),
                getApiAdapter(extractProviderUserId(accessGrant)));
    }

    /**
     * 创建：李启云
     * 日期：2020-09-29
     * 描述：提取提供者的用户id
     * 由于微信的openId是和accessToken一起返回的，所以在这里直接根据accessToken设置providerUserId即可，
     * 不用像QQ那样通过QQAdapter来获取
     *
     * @param accessGrant 访问授权
     * @return {@link String }
     */
    @Override
    protected String extractProviderUserId(AccessGrant accessGrant) {
        if (accessGrant instanceof WeiXinAccessGrant) {
            return ((WeiXinAccessGrant) accessGrant).getOpenId();
        }
        return null;
    }


    /**
     * 创建：李启云
     * 日期：2020-09-29
     * 描述：创建连接
     *
     * @param data 数据
     * @return {@link Connection<WeiXin> }
     */
    @Override
    public Connection<WeiXin> createConnection(ConnectionData data) {
        return new OAuth2Connection<>(data, getOAuth2ServiceProvider(), getApiAdapter(data.getProviderUserId()));
    }

    /**
     * 创建：李启云
     * 日期：2020-09-29
     * 描述：获得api适配器
     * WeiXinAdapter应该是多实例的----providerUserId即openId不一样，便不是一个用户
     *
     * @param providerUserId 提供用户id
     * @return {@link ApiAdapter<WeiXin> }
     */
    private ApiAdapter<WeiXin> getApiAdapter(String providerUserId) {
        return new WeiXinAdapter(providerUserId);
    }

    /**
     * 创建：李启云
     * 日期：2020-09-29
     * 描述：得到oauth2服务提供者
     *
     * @return {@link OAuth2ServiceProvider<WeiXin> }
     */
    private OAuth2ServiceProvider<WeiXin> getOAuth2ServiceProvider() {
        return (OAuth2ServiceProvider<WeiXin>) getServiceProvider();
    }
}
