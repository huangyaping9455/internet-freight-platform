/**
 *
 */
package com.rising.rbac.service.impl;

import com.rising.rbac.controller.support.RisingBeanUtil;
import com.rising.rbac.domain.Admin;
import com.rising.rbac.domain.Resource;
import com.rising.rbac.dto.ResourceInfo;
import com.rising.rbac.repository.AdminRepository;
import com.rising.rbac.repository.ResourceRepository;
import com.rising.rbac.service.IResourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author 李启云
 */
@Service
@Transactional
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public ResourceInfo getTree(Long adminId) throws Exception {
        Admin admin = adminRepository.findById(adminId).orElse(null);
        return resourceRepository.findByName("root").toTree(admin);
    }

    @Override
    public List<ResourceInfo> getResourceList(Long id) throws Exception {
        Admin admin = adminRepository.findById(id).orElse(null);
        return resourceRepository.findByName("root").resourceList(admin);
    }


    @Override
    public ResourceInfo getInfo(Long id) {
        Resource resource = resourceRepository.findById(id).get();
        ResourceInfo resourceInfo = new ResourceInfo();
        BeanUtils.copyProperties(resource, resourceInfo);
        resourceInfo.setMenuId(resource.getId());
        resourceInfo.setParentId(resource.getParent().getId());
        return resourceInfo;
    }

    @Override
    public ResourceInfo create(ResourceInfo info) {
        Resource parent = resourceRepository.findById(info.getParentId()).get();
        if (parent == null) {
            parent = resourceRepository.findByName("root");
        }
        Resource resource = new Resource();
        BeanUtils.copyProperties(info, resource);
        resource.setParentName(parent.getName());
        Set<String> perms = getPermsCollect(info);
        resource.setPerms(info.getPerms());
        resource.setUrls(perms);
        parent.addChild(resource);
        info.setMenuId(resourceRepository.save(resource).getId());
        return info;
    }

    private Set<String> getPermsCollect(ResourceInfo info) {
        return Arrays.stream(StringUtils.deleteWhitespace(info.getPerms()).split(","))
                .collect(Collectors.toSet());
    }


    @Override
    public ResourceInfo update(ResourceInfo info) {
        Optional<Resource> resourceOptional = resourceRepository.findById(info.getMenuId());
        Optional<Resource> parentOptional = resourceRepository.findById(info.getParentId());
        if (resourceOptional.isPresent() && parentOptional.isPresent()) {
            Resource resource = resourceOptional.get();
            Resource parent = parentOptional.get();
            //不拷贝属性值为null的字段
            RisingBeanUtil.copyPropertiesIgnoreNull(info, resource);
            resource.setParent(parent);
            resource.setParentName(parent.getName());
            resourceRepository.save(resource);
        }
        return info;
    }

    @Override
    public void delete(Long id) {
        resourceRepository.deleteById(id);
    }

    /**
     * (non-Javadoc)
     *
     * @see IResourceService#move(java.lang.Long, boolean)
     */
    @Override
    public Long move(Long id, boolean up) {
        Resource resource = resourceRepository.findById(id).get();
        int index = resource.getSort();
        List<Resource> childs = resource.getParent().getChilds();
        for (int i = 0; i < childs.size(); i++) {
            Resource current = childs.get(i);
            if (current.getId().equals(id)) {
                if (up) {
                    if (i != 0) {
                        Resource pre = childs.get(i - 1);
                        resource.setSort(pre.getSort());
                        pre.setSort(index);
                        resourceRepository.save(pre);
                    }
                } else {
                    if (i != childs.size() - 1) {
                        Resource next = childs.get(i + 1);
                        resource.setSort(next.getSort());
                        next.setSort(index);
                        resourceRepository.save(next);
                    }
                }
            }
        }
        resourceRepository.save(resource);
        return resource.getParent().getId();
    }

    @Override
    public ResourceInfo findByName(String name) {
        ResourceInfo resourceInfo = new ResourceInfo();
        Resource root = resourceRepository.findByName(name);
        BeanUtils.copyProperties(root, resourceInfo);
        resourceInfo.setMenuId(root.getId());
        resourceInfo.setParentId(-1L);
        return resourceInfo;
    }


}
