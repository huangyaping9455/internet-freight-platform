/**
 *
 */
package com.rising.rbac.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rising.rbac.domain.Organization;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 李启云
 */

@Data
public class AdminInfo implements Serializable {
    private Long id;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色ID")

    @NotBlank(message = "角色id不能为空")
    private List<Long> roleIdList;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "登录名")
    @NotBlank(message = "用户名不能为空")
    private String username;


    @ApiModelProperty(value = "用户真实姓名")
    private String name;
    @JsonIgnore
    private String password;
    private String oldPassword;
    private String newPassword;

    @ApiModelProperty(value = "组织机构ID")
    private Long organizationId;

    private String organizationName;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String mobile;


    private LocalDateTime createTime;
    @ApiModelProperty(value = "更新时间")

    private LocalDateTime updateTime;

    private boolean isDelete;
    @ApiModelProperty(value = "操作人")
    private String operator;

    private OrganizationInfo organization;

}
