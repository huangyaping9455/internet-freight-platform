package com.rising.security.core.properties;

import com.rising.security.core.social.configutils.SocialProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class QQProperties extends SocialProperties {
    private String providerId = "qq";
}
