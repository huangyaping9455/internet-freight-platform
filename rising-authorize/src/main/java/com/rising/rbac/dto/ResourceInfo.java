/**
 *
 */
package com.rising.rbac.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * 描述信息：资源信息
 * <p>
 * 创建作者：李启云
 * 创建日期：2020-08-28
 */

@Data
@ToString
public class ResourceInfo implements Serializable {

    /**
     * 资源ID

     */

    private Long menuId;
    /**
     *
     */
    private Long parentId;
    /**
     * 资源名

     */
    private String name;


    /**
     * 父母的名字
     */
    private String parentName;
    /**
     * 资源链接

     */
    private String url;
    /**
     * 权限
     */
    private String perms;
    /**
     * 图标
     */
    private String icon;
    /**
     * 资源类型
     */
    private Integer type;


    private int sort;


    private LocalDateTime createTime;
    @ApiModelProperty(value = "更新时间")

    private LocalDateTime updateTime;

    private boolean isDelete;
    @ApiModelProperty(value = "操作人")
    private String operator;
    /**
     * 子节点
     */
    private List<ResourceInfo> list = new ArrayList<>();

    Set<String> permissions ;





}
