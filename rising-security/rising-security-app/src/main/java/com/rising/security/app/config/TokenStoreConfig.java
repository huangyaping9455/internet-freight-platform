package com.rising.security.app.config;

import com.rising.security.core.properties.RisingSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;


/**
 * 描述：TokenStore的实现类有5个，可以在yml里通过配置指定使用RedisTokenStore还是JwtTokenStore
 * {@link TokenStore }
 * 创建时间：2020-02-01 23:20:43
 * 创建作者：李启云
 */
@Configuration
public class TokenStoreConfig {

    /***
     * RedisTokenStore需要一个连接工厂，这里可以直接注入进来
     */
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    /***
     * 将RedisTokenStore注入到spring容器
     * 当yml配置文件里配置了rising.security.oauth2.tokenStore = redis时 ---> 下面的配置生效
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "rising.security.oauth2", name = "tokenStoreType", havingValue = "redis")
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    /***
     *
     * 不配值存储方式时 默认是JWt
     * 当yml配置文件里配置了rising.security.oauth2.tokenStore = jwt或者根本就没配置该属性时 ---> 下面的配置生效
     */
    @Configuration
    @ConditionalOnProperty(prefix = "rising.security.oauth2", name = "tokenStoreType", havingValue = "jwt", matchIfMissing = true)
    public static class JwtConfig {

        @Autowired
        private RisingSecurityProperties securityProperties;
        @Autowired
        private UserDetailsService userDetailsService;

        /***
         * 配置JwtTokenStore ---> TokenStore只负责token的存储，不负责token的生成
         * @return
         */
        @Bean
        public TokenStore jwtTokenStore() {
            return new JwtTokenStore(jwtAccessTokenConverter());
        }

        /***
         * JwtAccessTokenConverter 其实就是一个TokenEnhancer
         * 通过阅读源码可知：TokenEnhancer是对生成的Token进行后续处理的（或者说增强），
         * 其实JwtAccessTokenConverter就是将默认生成的token做进一步处理使其成为一个JWT
         * @return
         */
        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            //加入密签 --- 一定要保护好
            converter.setAccessTokenConverter(getAccessTokenConverter());
            //字符串签名开发测试时候可以用
//            converter.setSigningKey(securityProperties.getOauth2().getJwtSigningKey());
            //生产环境使用秘钥库文件签名
            KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("rising.key"), "123456".toCharArray());
            converter.setKeyPair(keyStoreKeyFactory.getKeyPair("rising"));
            return converter;
        }

        /**
         * <p> 方法描述：令牌转换器. </p>
         * <p> 创建时间：2020-05-24 20:48:32 </p>
         * <p> 创建作者：李启云 </p>
         * <p> 修改作者： </p>
         *
         * @return the access token converter
         */
        private AccessTokenConverter getAccessTokenConverter() {
            DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
            DefaultUserAuthenticationConverter userAuthenticationConverter = new DefaultUserAuthenticationConverter();
            //不设置userDetailsService @AuthenticationPrincipal注解就拿不到实现了UserDitails 的对象  只能拿到String  username
            userAuthenticationConverter.setUserDetailsService(userDetailsService);
            accessTokenConverter.setUserTokenConverter(userAuthenticationConverter);
            return accessTokenConverter;

        }

        /***
         * 将自定义的TokenEnhancer注入到spring容器 --- 》可以覆盖该bean，实现自己的需求
         * @return
         */
//        @Bean
//        @ConditionalOnBean(TokenEnhancer.class)
//        public TokenEnhancer jwtTokenEnhancer() {
//            return new RisingJwtTokenEnhancer();
//        }
    }
}
