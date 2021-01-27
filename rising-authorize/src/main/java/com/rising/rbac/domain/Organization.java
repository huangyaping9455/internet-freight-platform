package com.rising.rbac.domain;

import com.rising.common.web.annotation.Comment;
import com.rising.rbac.dto.OrganizationInfo;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 描述：组织
 *
 * @see Model
 * 作者：李启云
 * 日期：2021-01-07
 */

@Entity
@Table(name = "sys_organization")
public class Organization extends Model {

    @ApiModelProperty(value = "机构名称")
    @Comment("机构名称")
    private String name;
    @ApiModelProperty(value = "父组织机构")
    @ManyToOne
    private Organization parent;
    private Long oldCompanyId;
    @ApiModelProperty(value = "排序序号")
    @Comment("排序序号")
    private int sort;

    @ApiModelProperty(value = "当前版本")
    @Comment("当前版本")
    private String version;
    @ApiModelProperty(value = "续期时间")
    @Comment("续期时间")
    private LocalDateTime renewalDate;
    @ApiModelProperty(value = "到期时间")
    @Comment("到期时间")
    private LocalDateTime expirationDate;
    @ApiModelProperty(value = "公司地区")
    @Comment("公司地区")
    private String companyArea;
    @ApiModelProperty(value = "公司地址")
    @Comment("公司地址")
    private String companyAddress;
    @ApiModelProperty(value = "营业执照-图片ID")
    @Comment("营业执照-图片ID")
    private String businessLicenseId;
    @ApiModelProperty(value = "法人代表")
    @Comment("法人代表")
    private String legalRepresentative;
    @ApiModelProperty(value = "公司电话")
    @Comment("公司电话")
    private String companyPhone;
    @ApiModelProperty(value = "邮箱")
    @Comment("邮箱")
    private String mailbox;
    @ApiModelProperty(value = "公司规模")
    @Comment("公司规模")
    private String companySize;
    @ApiModelProperty(value = "所属行业")
    @Comment("所属行业")
    private String industry;
    @ApiModelProperty(value = "备注")
    @Comment("备注")
    private String remarks;
    @ApiModelProperty(value = "当前余额")
    @Comment("当前余额")
    private BigDecimal balance;
    @ApiModelProperty(value = "组织机构类型(公司，部门)")
    //@Enumerated(EnumType.STRING)
    @Comment("组织机构类型(公司，部门)")
    private Integer type;

    @Comment("信用代码")
    private String creditId;
    @OneToMany(mappedBy = "parent")
    @OrderBy("sort Asc")
    private List<Organization> childs = new ArrayList<>();

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private Set<Admin> admins = new HashSet<>();

    @ApiModelProperty(value = "用户组所拥有的角色")
    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    private Set<RoleOrganization> organizations = new HashSet<>();

    public void addChild(Organization child) {
        childs.add(child);
        child.setParent(this);
    }


    /**
     * 创建：李启云
     * 日期：2020-12-04
     * 描述：组织列表
     *
     * @param admin 管理
     * @return {@link List<OrganizationInfo> }
     * @throws Exception 异常
     */
    public List<OrganizationInfo> organizationList(Admin admin) throws Exception {

        Set<Long> organizationIds = admin.getAllOrganizationIds();
        List<OrganizationInfo> list = new ArrayList<>();
        Stack<Organization> stack = new Stack<>();
        List<Organization> root = getChilds();
        root.forEach(stack::push);
        while (!stack.isEmpty()) {
            OrganizationInfo organizationInfo = new OrganizationInfo();
            Organization organization = stack.pop();
            if (StringUtils.equals(admin.getUsername(), "admin") ||
                    organizationIds.contains(organization.getId())) {
                BeanUtils.copyProperties(organization, organizationInfo);
                organizationInfo.setParentId(organization.getParent().getId());
                organizationInfo.setParentName(organization.getParent().getName());
                list.add(organizationInfo);
            }
            // list.add(resourceInfo);
            List<Organization> childs = organization.getChilds();
            if (childs != null && childs.size() > 0) {
                childs.forEach(stack::push);
            }
        }
        return list;
    }


    //==================getter======setter=============================


    public Long getOldCompanyId() {
        return oldCompanyId;
    }

    public void setOldCompanyId(Long oldCompanyId) {
        this.oldCompanyId = oldCompanyId;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization getParent() {
        return parent;
    }

    public void setParent(Organization parent) {
        this.parent = parent;
    }

    public List<Organization> getChilds() {
        return childs;
    }

    public void setChilds(List<Organization> childs) {
        this.childs = childs;
    }

    public Set<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<Admin> admins) {
        this.admins = admins;
    }

    public Set<RoleOrganization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<RoleOrganization> organizations) {
        this.organizations = organizations;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDateTime getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(LocalDateTime renewalDate) {
        this.renewalDate = renewalDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCompanyArea() {
        return companyArea;
    }

    public void setCompanyArea(String companyArea) {
        this.companyArea = companyArea;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getBusinessLicenseId() {
        return businessLicenseId;
    }

    public void setBusinessLicenseId(String businessLicenseId) {
        this.businessLicenseId = businessLicenseId;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void addAdmin(Admin admin) {
        if (admin != null) {
            admins.add(admin);

        }

    }


}
