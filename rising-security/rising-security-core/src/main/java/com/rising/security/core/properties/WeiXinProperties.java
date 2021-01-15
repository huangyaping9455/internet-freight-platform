package com.rising.security.core.properties;

import com.rising.security.core.social.configutils.SocialProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 描述：Wei xin properties
 * 创建时间：2020-02-01 16:02:06
 * 创建作者：李启云
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WeiXinProperties extends SocialProperties {
    private String providerId = "weixin";
}
