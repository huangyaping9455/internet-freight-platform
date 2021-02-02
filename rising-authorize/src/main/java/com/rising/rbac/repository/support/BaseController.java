package com.rising.rbac.repository.support;


import com.rising.common.web.exception.ExceptionCast;
import com.rising.common.web.result.IResultCode;
import com.rising.rbac.domain.Admin;
import com.rising.rbac.domain.Organization;
import com.rising.rbac.dto.AdminInfo;
import com.rising.rbac.dto.OrganizationInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.security.Principal;
import java.util.concurrent.TimeUnit;

/**
 * 描述：基本控制器
 * <p>
 * 作者：李启云
 * 日期：2020-10-13
 */

@RestController
public abstract class BaseController {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    protected Admin admin;

    /**
     * 创建：李启云
     * 日期：2020-12-14
     * 描述：设置管理
     *
     * @param admin 管理
     * @return
     */
   // @ModelAttribute
    protected void setAdmin( @AuthenticationPrincipal Admin admin) {
        if (redisTemplate.hasKey(getKey(admin))) {
            this.admin = (Admin) redisTemplate.opsForValue().get(getKey(admin));
            return;
        }
        redisTemplate.opsForValue().set(getKey(admin), admin, 60 * 2, TimeUnit.MINUTES);
        this.admin = admin;
    }
    private String getKey(Admin admin) {
        return "rising:security:login.user." + admin.getName();
    }

    /**
     * 创建：李启云
     * 日期：2020-10-13
     * 描述：投
     *
     * @param resultCode 结果代码
     * @return
     */
    protected void cast(IResultCode resultCode) {
        ExceptionCast.cast(resultCode);
    }
}
