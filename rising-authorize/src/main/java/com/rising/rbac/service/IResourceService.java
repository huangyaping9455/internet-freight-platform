/**
 *
 */
package com.rising.rbac.service;


import com.rising.rbac.dto.ResourceInfo;

import java.util.List;

/**
 * 资源服务
 */
public interface IResourceService {

    /**
     * 获取资源树
     *
     * @param adminId the admin id
     * @return the resource info
     * @date 2015年7月10日下午7 :08:26
     * @since 1.0.0
     */
    ResourceInfo getTree(Long adminId) throws Exception;


    List<ResourceInfo>  getResourceList(Long id) throws Exception;

    /**
     * 根据资源ID获取资源信息
     *
     * @param id 资源ID
     * @return ResourceInfo 资源信息
     * @date 2015年7月10日下午7:01:48
     * @since 1.0.0
     */
    ResourceInfo getInfo(Long id);

    /**
     * 新增资源
     *
     * @param info 页面传入的资源信息
     * @return ResourceInfo 资源信息
     * @date 2015年7月10日下午7:01:51
     * @since 1.0.0
     */
    ResourceInfo create(ResourceInfo info);

    /**
     * 更新资源
     *
     * @param info 页面传入的资源信息
     * @return ResourceInfo 资源信息
     * @date 2015年7月10日下午7:01:54
     * @since 1.0.0
     */
    ResourceInfo update(ResourceInfo info);

    /**
     * 根据指定ID删除资源信息
     *
     * @param id 资源ID
     * @date 2015年7月10日下午7:01:57
     * @since 1.0.0
     */
    void delete(Long id);

    /**
     * 上移/下移资源
     *
     * @param id
     * @param up
     */
    Long move(Long id, boolean up);

    ResourceInfo findByName(String root);
}
