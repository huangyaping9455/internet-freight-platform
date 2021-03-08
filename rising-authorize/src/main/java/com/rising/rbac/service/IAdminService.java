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

    /**
     * 码农：李齐云
     * 日期：2021-03-04
     * 描述：查询
     * <p>
     * 返回值：{@link Page<AdminInfo> }
     *
     * @param username  用户名
     * @param condition 条件
     * @param pageable  可分页
     */
    Page<AdminInfo> query( String username, AdminCondition condition, Pageable pageable);

    /**
     * 码农：李齐云
     * 日期：2021-03-04
     * 描述：删除由ids
     * <p>
     * 返回值：
     *
     * @param ids id
     */
    void deleteByIds(List<Long> ids);

    /**
     * 码农：李齐云
     * 日期：2021-03-04
     * 描述：找到的用户名
     * <p>
     * 返回值：{@link Admin }
     *
     * @param username 用户名
     */
    Admin findByUsername(String username);

    /**
     * 码农：李齐云
     * 日期：2021-03-04
     * 描述：更新密码
     * <p>
     * 返回值：{@link AdminInfo }
     *  @param id          id
     * @param password    密码
     * @param newPassword 新密码
     * @return
     */
    boolean updatePassword(Long id, String password, String newPassword);
}
