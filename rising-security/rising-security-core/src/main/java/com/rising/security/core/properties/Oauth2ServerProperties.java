package com.rising.security.core.properties;

import lombok.Data;


/**
 * 描述：Oauth 2 server properties
 * 创建时间：2020-02-02 13:15:05
 * 创建作者：李启云
 */
@Data
public class Oauth2ServerProperties {
    /***
     *  jwt的密签 --- 发出去的令牌需要它签名，验证令牌时也用它来验
     *  ★一定要保护好，别人知道了就可以拿着它来签发你的jwt令牌了
     */
    private String jwtSigningKey = "rising";

    /***
     * 指定使用哪个TokenStoreType
     */
    private String tokenStoreType;

    private String clientId;
    private String clientSecret;
}
