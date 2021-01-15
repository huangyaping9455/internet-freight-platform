package com.rising.security.core.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * 授权配置管理器
 * 描述:
 *
 * @author 李启云
 * @ProjectName risingdog
 * @ClassName: RisingAuthorizeConfigManager
 * @date 2020/4/18 21:12
 */
public interface AuthorizeConfigManager {

    /**
     * <p> 方法描述返回的boolean表示配置中是否有针对anyRequest的配置。在整个授权配置中，
     *  应该有且仅有一个针对anyRequest的配置，如果所有的实现都没有针对anyRequest的配置，
     *  系统会自动增加一个anyRequest().authenticated()的配置。如果有多个针对anyRequest
     *  的配置，则会抛出异常。
     * <p> 创建时间：2020-04-18 20:54:15 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     * @param config the config
     * @return the boolean
     */
    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);
}
