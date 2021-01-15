//package com.rising.security.app.pojo;
//
//import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.token.TokenEnhancer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
///**
// * 描述：自定义一个TokenEnhancer，在生成JWT时加入一些扩展信息
// * 创建时间：2020-02-02 13:54:22
// * 创建作者：李启云
// */
//public class RisingJwtTokenEnhancer implements TokenEnhancer {
//    @Override
//    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//        //在jwt里加入一个company信息
//        Map<String, Object> info = new HashMap<>();
//        info.put("company", "Rising");
//
//        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
//        return accessToken;
//    }
//}
