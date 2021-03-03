package com.rising.freight.dto;


import com.rising.freight.domain.InternetDriver;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述：
 * 网络货运平台车辆基础信息传输对象
 *
 * @see Serializable
 * 作者：李启云
 * 日期：2020-12-31
 */
@Data
@ApiModel(value = "车辆基础信息传输对象")
public class InternetCarDto implements Serializable {
    private String id;
    @ApiModelProperty(value = "公司ID")
    private String organizationId;
    @ApiModelProperty(value = "车辆的驾驶员列表")
    private Set<InternetDriver> drivers = new HashSet<>();
    @ApiModelProperty(value = "车辆牌照号",required = true)
    private String vehicleNumber;
    @ApiModelProperty(value = "车牌颜色代码", required = true)
    private String vehiclePlateColorCode;
    @ApiModelProperty(value = "车辆类型代码", required = true)
    private String vehicleType;
    @ApiModelProperty(value = "所有人", notes = "总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。")
    private String owner;
    @ApiModelProperty(value = "使用性质", required = true, notes = "总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。")
    private String useCharacter;
    @ApiModelProperty(value = "车辆识别代号", required = true, notes = "总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。")
    private String vin;
    @ApiModelProperty(value = "发证机关", required = true, notes = "总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。")
    private String issuingOrganizations;
    @ApiModelProperty(value = "注册日期", dataType = "Date", required = true, notes = "总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。YYYYMMDD")
    private LocalDate registerDate;
    @ApiModelProperty(value = "发证日期", dataType = "Date", required = true, notes = "总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。YYYYMMDD")
    private LocalDate issueDate;
    @ApiModelProperty(value = "车辆能源类型", required = true)
    private String vehicleEnergyType;
    @Column(precision = 24, scale = 2)
    @ApiModelProperty(value = "核定载质量", dataType = "BigDecimal", required = true, notes = "默认单位：吨，保留两位小数，如整数的话，以.00 填充。小数点不计入总长。")
    private BigDecimal vehicleTonnage;
    @Column(precision = 24, scale = 2)
    @ApiModelProperty(value = "吨位", dataType = "BigDecimal", required = true, notes = "1..1 n..9,2 必填，车辆总质量，默认单位：吨，保留两位小数，如整数的话，以.00 填充。小数点不计入总长")
    private BigDecimal grossMass;
    @ApiModelProperty(value = "道路运输证号", dataType = "Long", required = true, notes = "必填,总质量 4.5 吨及以下普通货运车辆的可填“车籍地6位行政区域代码+000000”")
    private Long roadTransportCertificateNumber;
    @ApiModelProperty(value = "挂车牌照号")
    private String trailerVehiclePlateNumber;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty("车辆附件urls")
    private Set<String> carAttachmentURLs;


}
