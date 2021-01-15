package com.rising.freight.domain;

import com.rising.common.web.annotation.Comment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
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
    @GeneratedValue( generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.rising.common.support.CustomIDGenerator")
    private String id;
    @ApiModelProperty(value = "公司ID")
    private String organizationId;
    @ApiModelProperty(value = "创建时间")
    @CreatedDate
    @Column(name = "create_time", updatable = false, nullable = false)
    private LocalDateTime createTime;
    @ApiModelProperty(value = "更新时间")
    @LastModifiedDate
    private LocalDateTime updateTime;
    @Column(columnDefinition = "bit(1) default false", nullable = false)
    private boolean isDelete;
    @ApiModelProperty(value = "操作人")
    @LastModifiedBy
    private String operator;
    @Comment("状态")
    private int status;

}
