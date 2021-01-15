package com.rising.security.core.authorize;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:
 *
 * @author 李启云
 * @ProjectName master
 * @ClassName: PermissionService
 * @date 2020/5/24 09:06
 */
public interface PermissionService {

    /**
     * <p> 方法描述：是否有权限. </p>
     * <p> 创建时间：2020-05-03 10:35:43 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param request        the request
     * @param authentication the authentication
     * @return the boolean
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
