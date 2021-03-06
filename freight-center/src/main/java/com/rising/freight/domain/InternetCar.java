package com.rising.freight.domain;


import com.rising.common.web.annotation.Comment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述：
 * 网络货运平台车辆基础数据存储
 *
 * @see Serializable
 * 作者：李启云
 * 日期：2020-12-31
 */
@Entity
@Table(name = "internet_car")
@Getter
@Setter
@Comment(" 网络货运平台车辆基础数据")
public class InternetCar extends Model {

    @JoinTable(name = "internet_car_driver",
            joinColumns = {@JoinColumn(name = "car_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "driver_id", referencedColumnName = "id")})
    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<InternetDriver> internetDrivers = new HashSet<>();

    @JoinTable(name = "internet_car_goods",
            joinColumns = {@JoinColumn(name = "car_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "goods_id", referencedColumnName = "id")})
    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<ShippingGoods> goodsInfos = new HashSet<>();


    // 车辆牌照号	1..1	an..35	必填，对应运单技术规范第 26 项。
    private String vehicleNumber;
    /**
     * 代码 名称 代码 名称
     * 1 蓝色 4 白色
     * 2 黄色 5 绿色
     * 3 黑色 9 其他
     * 91 农黄色 92 农绿色
     * 93 黄绿色 94 渐变绿
     */
    // 	1..1	an..2	必填，21
    @Comment("车牌颜色代码")
    private String vehiclePlateColorCode;
    // 	1..1	an..3	必填。参考机动车行驶证填写，代码集参见 wlhy.mot.gov.cn。
    @Comment("车辆类型代码")
    private String vehicleType;
    // 	0..1	an..128	总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。
    @Comment("所有人")
    private String owner;
    // 	0..1	an..20	总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。
    @Comment("使用性质")
    private String useCharacter;
    // 	0..1	an..32	总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。
    @Comment("车辆识别代号")
    private String vin;
    // 	0..1	an..128	总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。
    @Comment("发证机关")
    private String issuingOrganizations;
    // 	0..1	n8	总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。YYYYMMDD

    @Comment("注册日期")
    private LocalDate registerDate;
    // 	0..1	n8	总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。YYYYMMDD

    @Comment("发证日期")
    private LocalDate issueDate;
    /**
     * 代 码 能源类型 说明
     * A 汽油
     * B 柴油
     * C 电 以电能驱动的汽车
     * D 混合油
     * E 天然气
     * F 液化石油气
     * L 甲醇
     * M 乙醇
     * N 太阳能
     * O 混合动力
     * Y 无 仅限全挂车等无动力的
     * Z 其他
     */
    // 	1..1	an..12	必填，代码集参见wlhy.mot.gov.cn。
    @Comment("车辆能源类型")
    private String vehicleEnergyType;
    // 	1..1	n..9,2	必填，参考机动车行驶证填写，默认单位：
    //吨，保留两位小数，如整数的话，以.00 填
    //充。小数点不计入总长。
    @Column(precision = 24, scale = 2)
    @Comment("核定载质量")
    private BigDecimal vehicleTonnage;
    // 	1..1	n..9,2	必填，车辆总质量，默认单位：吨，保留两
    //位小数，如整数的话，以.00 填充。小数点不计入总长
    @Column(precision = 24, scale = 2)
    @Comment("吨位")
    private BigDecimal grossMass;
    // 	1..1	n..20	必填，总质量 4.5 吨及以下普通货运车辆
    //的，可填“车籍地 6 位行政区域代码
    //+000000”。
    @Comment("道路运输证号")
    private Long roadTransportCertificateNumber;
    // 	0..1	an..35	选填。
    @Comment("挂车牌照号")
    private String trailerVehiclePlateNumber;
    // 	0..1	an..256	选填。
    @Comment("备注")
    private String remark;

    @Comment("车辆附件URL")
    @ElementCollection
    @CollectionTable(name = "internet_car_attachment_urls")
    private Set<String> carAttachmentURLs;


    public void addDriver(InternetDriver driver) {
        if (driver != null) {
            internetDrivers.add(driver);
        }

    }
}
