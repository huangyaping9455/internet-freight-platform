/**
 *
 */
package com.rising.rbac.service;

import com.rising.rbac.domain.Admin;
import com.rising.rbac.dto.AdminInfo;
import com.rising.rbac.dto.condition.AdminCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 描述：iadmin服务
 * <p>
 * 作者：李启云
 * 日期：2020-11-24
 */
public interface IAdminService {


    /**
     * Create admin info.
     *
     * @param adminInfo the admin info
     * @return the admin info
     */
    AdminInfo create(AdminInfo adminInfo);

    /**
     * 修改管理员
     *
     * @param adminInfo
     * @return
     */
    AdminInfo update(AdminInfo adminInfo);

    /**
     * 删除管理员
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 获取管理员详细信息
     *
     * @param id
     * @return
     */
    AdminInfo getInfo(Long id);

    /**
     * 分页查询管理员
     *
     * @param condition the condition
     * @param pageable  the pageable
     * @return page
     */
    Page<AdminInfo> query(AdminCondition condition, Pageable pageable);

    Page<AdminInfo> query( String username, AdminCondition condition, Pageable pageable);

    void deleteByIds(List<Long> ids);

    Admin findByUsername(String username);
}
