/**
 *
 */
package com.rising.rbac.domain;

import com.rising.common.web.annotation.Comment;
import com.rising.rbac.dto.ResourceInfo;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 需要控制权限的资源，以业务人员能看懂的name呈现.实际关联到一个或多个url上。
 * <p>
 * 树形结构。
 *
 * @author liqiyun
 */
@Entity
@Table(name = "sys_resource")
public class Resource extends Model {


    @ApiModelProperty(value = "资源名称，如xx菜单，xx按钮")
    @Comment("资源名称，如xx菜单，xx按钮")
    private String name;

    @ApiModelProperty(value = "父资源名称")
    @Comment("父资源名称")
    private String parentName;


    @ApiModelProperty(value = "资源链接")
    @Comment("资源链接")
    private String url;


    @ApiModelProperty(value = "权限")
    @Comment("权限")
    private String perms;


    @ApiModelProperty(value = "图标")
    @Comment("图标")
    private String icon;

    @ApiModelProperty(value = "排序序号")
    @Comment("排序序号")
    private int sort;

    // @Enumerated(EnumType.STRING)
    @Column(length = 11)
    @ApiModelProperty(value = "资源类型")
    @Comment("资源类型")
    private Integer type;

    @ElementCollection
    @CollectionTable(name = "sys_resource_urls")
    @ApiModelProperty(value = "实际需要控制权限的url")
    @Comment("实际需要控制权限的url")
    private Set<String> urls;
    /**
     * 父资源
     */
    @ManyToOne
    private Resource parent;
    /**
     * 子资源
     */
    @OneToMany(mappedBy = "parent")
    @OrderBy("sort ASC")
    private List<Resource> childs = new ArrayList<>();

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @ApiModelProperty(value = "父ID，不持久化到数据库")
    @Transient
    private Long parentId;


    /**
     * <p> 方法描述：构建树形菜单. </p>
     * <p> 创建时间：2020-05-01 23:42:06 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param admin the admin
     * @return the resource info
     */
    public ResourceInfo toTree(Admin admin) throws Exception {
        ResourceInfo result = new ResourceInfo();
        setProp(result);
        Set<Long> resourceIds = admin.getAllResourceIds();
        List<ResourceInfo> children = new ArrayList<>();
        for (Resource child : getChilds()) {
            Long parentId = child.getParent().getId();
            child.setParentId(parentId);
            if (StringUtils.equals(admin.getUsername(), "admin") ||
                    resourceIds.contains(child.getId())) {
                children.add(child.toTree(admin));
            }
        }
        result.setList(children);
        return result;
    }


    /**
     * 创建：李启云
     * 日期：2020-11-26
     * 描述：资源列表
     *
     * @param admin 管理
     * @return {@link List<ResourceInfo> }
     * @throws Exception 异常
     */
    public List<ResourceInfo> resourceList(Admin admin) throws Exception {
        Set<Long> resourceIds = admin.getAllResourceIds();
        List<ResourceInfo> list = new ArrayList<>();
        Stack<Resource> stack = new Stack<>();
        List<Resource> root = getChilds();
        root.forEach(stack::push);
        while (!stack.isEmpty()) {
            ResourceInfo resourceInfo = new ResourceInfo();
            Resource resource = stack.pop();
            if (StringUtils.equals(admin.getUsername(), "admin") ||
                    resourceIds.contains(resource.getId())) {
                BeanUtils.copyProperties(resource, resourceInfo);
                resourceInfo.setParentId(resource.getParent().getId());
                resourceInfo.setMenuId(resource.getId());
                list.add(resourceInfo);
            }
            // list.add(resourceInfo);
            List<Resource> childs = resource.getChilds();
            if (childs != null && childs.size() > 0) {
                childs.forEach(stack::push);
            }
        }
        return list;
    }


    /**
     * 创建：李启云
     * 日期：2020-12-11
     * 描述：设置支撑
     *
     * @param result 结果
     * @return
     */
    private void setProp(ResourceInfo result) {
        result.setPerms(this.perms);
        result.setMenuId(this.getId());
        result.setIcon(this.getIcon());
        result.setSort(this.getSort());
        result.setUrl(this.getUrl());
        result.setName(this.getName());
        result.setParentName(this.getParentName());
        result.setParentId(StringUtils.isBlank(this.getParentId() + "") ? this.getParentId() : 0L);
        result.setType(this.getType());
    }

    public void addChild(Resource child) {
        childs.add(child);
        child.setParent(this);
    }


    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Set<String> getUrls() {
        return urls;
    }

    public void setUrls(Set<String> urls) {
        this.urls = urls;
    }

    public Resource getParent() {
        return parent;
    }

    public void setParent(Resource parent) {
        this.parent = parent;
    }

    public List<Resource> getChilds() {
        return childs;
    }

    public void setChilds(List<Resource> childs) {
        this.childs = childs;
    }
}
