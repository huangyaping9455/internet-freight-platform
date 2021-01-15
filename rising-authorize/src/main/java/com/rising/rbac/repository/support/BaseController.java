package com.rising.rbac.repository.support;


import com.rising.common.web.exception.ExceptionCast;
import com.rising.common.web.result.IResultCode;
import com.rising.rbac.domain.Admin;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：基本控制器
 * <p>
 * 作者：李启云
 * 日期：2020-10-13
 */

@RestController
public abstract class BaseController {

    protected Admin admin;

    /**
     * 创建：李启云
     * 日期：2020-12-14
     * 描述：设置管理
     *
     * @param admin 管理
     * @return
     */
    @ModelAttribute
    protected void setAdmin( @AuthenticationPrincipal Admin admin) {
        this.admin = admin;

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
