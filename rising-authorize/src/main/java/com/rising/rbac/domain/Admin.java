/**
 *
 */
package com.rising.rbac.domain;

import com.rising.common.web.annotation.Comment;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.security.SocialUserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 描述：管理
 *
 * @see Model
 * @see UserDetails
 * @see SocialUserDetails
 * 作者：李启云
 * 日期：2020-11-30
 */
@Entity
@Table(name = "sys_admin")
public class Admin extends Model implements UserDetails, SocialUserDetails {


    private static final long serialVersionUID = -3521673552808391992L;

    @ApiModelProperty(value = "用户名")
    @Comment("用户名")
    private String name;
    @ApiModelProperty(value = "登录名名")
    @Comment("登录名名")
    private String username;
    @ApiModelProperty(value = "密码")
    @Comment("密码")
    private String password;
    @Comment("邮箱")
    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    @Comment("手机号")
    private String mobile;

    @ApiModelProperty(value = "用户所包含的组")
    @ManyToOne
    @JoinColumn(name = "organizationId")
    @Comment("用户所包含的组")
    private Organization organization;

    @ApiModelProperty(value = "用户的所有角色")
    @OneToMany(mappedBy = "admin", cascade = CascadeType.REMOVE)
    @Comment("用户的所有角色")
    private Set<RoleAdmin> roles = new HashSet<>();

    @ApiModelProperty(value = "用户有权访问的所有url，不持久化到数据库")
    @Transient
    private Set<String> urls = new HashSet<>();

    @ApiModelProperty(value = "用户有权的所有资源id，不持久化到数据库")
    @Transient
    private Set<Long> resourceIds = new HashSet<>();
    @ApiModelProperty(value = "用户有权的所有组织机构id，不持久化到数据库")
    @Transient
    private Set<Long> organizationIds = new HashSet<>();


    /**
     * (non-Javadoc)
     *
     * @see UserDetails#getAuthorities(
     *)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    /**
     * 获取所有的资源ids
     */
    public Set<Long> getAllOrganizationIds() {
        Set<Long> organizationIds = this.organization.getChilds().stream().map(Organization::getId).collect(Collectors.toSet());
        organizationIds.add(this.organization.getId());
        return organizationIds;
    }

    /**
     * 获取所有的资源ids
     */
    public Set<Long> getAllResourceIds() {
        init(resourceIds);
        forEachResource(resource -> resourceIds.add(resource.getId()));
        return resourceIds;
    }


    /**
     * 得到所有的urls
     *
     * @return the urls
     */
    public Set<String> getUrls() {
        init(urls);
        forEachResource(resource -> urls.addAll(resource.getUrls()));
        return urls;
    }

    /**
     * <p> 方法描述：Init. </p>
     * <p> 创建时间：2020-05-02 00:02:58 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param data the data
     */
    private void init(Set<?> data) {
        if (CollectionUtils.isEmpty(data)) {
            if (data == null) {
                data = new HashSet<>();
            }
        }
    }

    /**
     * @param consumer
     */
    private void forEachResource(Consumer<Resource> consumer) {
        for (RoleAdmin role : roles) {
            for (RoleResource resource : role.getRole().getResources()) {
                consumer.accept(resource.getResource());
            }
        }
    }


    /**
     * (non-Javadoc)
     *
     * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * (non-Javadoc)
     *
     * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 创建：李启云
     * 日期：2020-12-10
     * 描述：是账户非过期
     *
     * @return boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 创建：李启云
     * 日期：2020-12-10
     * 描述：是账户非锁定
     *
     * @return boolean
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 创建：李启云
     * 日期：2020-12-10
     * 描述：是凭证不过期
     *
     * @return boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * (non-Javadoc)
     *
     * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
     */
    @Override
    public boolean isEnabled() {
        return !this.isDelete();
    }

    /**
     * @return the roles
     */
    public Set<RoleAdmin> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Set<RoleAdmin> roles) {
        this.roles = roles;
    }


    /**
     * @param urls the urls to set
     */
    public void setUrls(Set<String> urls) {
        this.urls = urls;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Set<Long> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(Set<Long> resourceIds) {
        this.resourceIds = resourceIds;
    }

    public Set<Long> getOrganizationIds() {
        return organizationIds;
    }

    public void setOrganizationIds(Set<Long> organizationIds) {
        this.organizationIds = organizationIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getUserId() {
        return String.valueOf(super.getId());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
