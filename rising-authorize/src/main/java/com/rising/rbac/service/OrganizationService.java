package com.rising.rbac.service;

import com.rising.rbac.domain.Admin;
import com.rising.rbac.dto.OrganizationInfo;

import java.util.List;


/**
 * 描述：组织服务
 * <p>
 * 作者：李启云
 * 日期：2020-11-27
 */
public interface OrganizationService {


    /**
     * 创建：李启云
     * 日期：2020-12-09
     * 描述：得到信息
     *
     * @param admin          管理
     * @param organizationId 组织id
     * @return {@link OrganizationInfo }
     */
    OrganizationInfo getInfo(Admin admin, Long organizationId);

    OrganizationInfo getInfoByOldCompanyId( Long oldCompanyId);
    /**
     * <p> 方法描述：新增组织机构 </p>
     * <p> 创建时间：2020-05-27 11:21:11 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param info the info
     * @return the organization info
     */
    OrganizationInfo create(OrganizationInfo info);


    /**
     * <p> 方法描述：更新组织机构 </p>
     * <p> 创建时间：2020-05-27 11:21:14 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param info the info
     * @return the organization info
     */
    OrganizationInfo update(OrganizationInfo info);

    /**
     * <p> 方法描述：根据指定ID删除资源信息. </p>
     * <p> 创建时间：2020-05-27 11:21:16 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param id the id
     */
    void delete(Long id);

    /**
     * <p> 方法描述：上移/下移组织机构 </p>
     * <p> 创建时间：2020-05-27 11:21:19 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param id the id
     * @param up the up
     * @return the long
     */
    Long move(Long id, boolean up);

    /**
     * 创建：李启云
     * 日期：2020-11-30
     * 描述：得到组织列表
     *
     * @param id id
     * @return {@link List<OrganizationInfo> }
     */
    List<OrganizationInfo> getOrganizationList(Long id) throws Exception;

    /**
     * 创建：李启云
     * 日期：2020-11-30
     * 描述：找到的名字
     *
     * @param platform 平台
     * @return {@link OrganizationInfo }
     */
    OrganizationInfo findByName(String platform);
}
