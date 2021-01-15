package com.rising.rbac.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 描述：模型
 *
 * @see Serializable
 * 作者：李启云
 * 日期：2020-11-30
 */

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Model implements Serializable {
    @ApiModelProperty(value = "数据库表主键")
    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "bit(1) default false", nullable = false)
    private boolean isDelete;
    @ApiModelProperty(value = "创建时间")
    @CreatedDate
    @Column(name = "create_time", updatable = false, nullable = false)
    private LocalDateTime createTime;
    @ApiModelProperty(value = "更新时间")
    @LastModifiedDate
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "操作人")
    @LastModifiedBy
    private String operator;
    @ApiModelProperty(value = "状态")

    @Column(columnDefinition = "int default 0", nullable = false)
    private int status;


}
