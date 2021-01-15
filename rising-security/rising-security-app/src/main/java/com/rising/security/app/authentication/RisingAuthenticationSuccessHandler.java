package com.rising.security.app.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rising.security.core.properties.RisingSecurityProperties;
import com.rising.security.core.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * 描述：认证成功处理器r
 * 创建时间：2020-02-01 21:11:24
 *
 * @author liqiyun
 */
@Slf4j
@Component
public class RisingAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ClientDetailsService clientDetailsService;

   @Qualifier("defaultAuthorizationServerTokenServices")
    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @Autowired
    private RisingSecurityProperties risingSecurityProperties;

    /**
     * Authentication封装了用户认证成功的信息
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        logger.info("登录成功");
        //请求头的Authorization里存放了ClientId和ClientSecret
        //从请求头里获取Authorization信息可参考BasicAuthenticationFilter类

        //注意：这种方式登陆时候头信息里面必须包含客户端信息
/*        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Basic ")) {
            throw new UnapprovedClientAuthenticationException("请求头中无client信息");
        }

        String[] tokens = extractAndDecodeHeader(header, request);
        assert tokens.length == 2;
        String clientId = tokens[0];
        String clientSecret = tokens[1];*/

        //敏感信息在后端配置也可以请求的时候带在请求头里面
        String clientId = risingSecurityProperties.getOauth2().getClientId();
        String clientSecret = risingSecurityProperties.getOauth2().getClientSecret();

        // 根据clientId获取ClientDetails对象 --- ClientDetails为第三方应用的信息
        // 现在配置在了yml文件里，真实项目中应该放在数据库里
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);

        // 对获取到的clientDetails进行校验
        if (clientDetails == null) {
            throw new UnapprovedClientAuthenticationException("clientId对应的配置信息不存在:" + clientId);
        } else if (!passwordEncoder.matches(clientSecret, clientDetails.getClientSecret())) {
            throw new UnapprovedClientAuthenticationException("clientSecret不匹配:" + clientId);
        }

        //第一个参数为请求参数的一个Map集合，
        // 在Spring Security OAuth的源码里要用这个Map里的用户名+密码或授权码来生成Authentication对象,
        // 但我们已经获取到了Authentication对象，所以这里可以直接传一个空的Map
        //第三个参数为scope即请求的权限 ---》这里的策略是获得的ClientDetails对象里配了什么权限就给什么权限 //todo
        //第四个参数为指定什么模式 比如密码模式为password，授权码模式为authorization_code，
        // 这里我们写一个自定义模式custom
        TokenRequest tokenRequest = new TokenRequest(MapUtils.EMPTY_MAP, clientId, clientDetails.getScope(), "custom");

        //获取OAuth2Request对象
        //源码中是这么写的 ---
        // OAuth2Request storedOAuth2Request = getRequestFactory().createOAuth2Request(client, tokenRequest);
        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);

        //new出一个OAuth2Authentication对象
        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);

        //生成token
        OAuth2AccessToken token = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);

        //将生成的token返回
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(ResultVOUtil.success(token)));

    }

    /**
     * 创建：李启云
     * 日期：2020-12-10
     * 描述：提取和解码头
     *从header获取Authentication信息 --- 》 clientId和clientSecret
     * @param header  头
     * @param request 请求
     * @return {@link String[] }
     * @throws IOException ioexception
     */
    private String[] extractAndDecodeHeader(String header, HttpServletRequest request) throws IOException {

        byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
        byte[] decoded;
        try {
            decoded = Base64Utils.decode(base64Token);
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException("Failed to decode basic authentication token");
        }

        String token = new String(decoded, StandardCharsets.UTF_8);

        int delim = token.indexOf(":");

        if (delim == -1) {
            throw new BadCredentialsException("无效的Basic信息");
        }
        return new String[]{token.substring(0, delim), token.substring(delim + 1)};
    }


    public static void main(String[] args) {
        String pass = "admin";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(pass);
        System.out.println("encode = " + encode);
        boolean matches = passwordEncoder.matches(pass, "$2a$10$5g9xkfiGalK3qwZGnvu0Euwvi53ps/oiVpi34CHw2hhBKgj26/t4W");

        System.out.println("matches = " + matches);
    }
}