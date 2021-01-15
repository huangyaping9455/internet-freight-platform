/**
 *
 */
package com.rising.rbac.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author 李启云
 */

@Data
public class RoleInfo implements Serializable {

    private Long id;

    private String name;

    private String remark;
    private LocalDateTime createTime;
    @ApiModelProperty(value = "更新时间")

    private LocalDateTime updateTime;

    private boolean isDelete;
    @ApiModelProperty(value = "操作人")
    private String operator;

    private Set<Long> resourceIds;

    private Long organizationId;

}
