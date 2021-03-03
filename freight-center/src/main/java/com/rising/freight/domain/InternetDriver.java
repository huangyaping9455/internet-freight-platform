package com.rising.freight.domain;


import com.rising.common.web.annotation.Comment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述：驾驶员基础信息实体类
 *
 * @see Serializable
 * 作者：李启云
 * 日期：2020-12-31
 */
@Table(name = "internet_driver")
@Entity
@Getter
@Setter
@Comment("司机表")
public class InternetDriver  extends Model{
    private static final long serialVersionUID = 1L;


    @ManyToMany(mappedBy = "internetDrivers")

    private Set<InternetCar> InternetCars = new HashSet<>();

    @Comment("司机姓名")
    private String driverName;

    @Comment("驾驶证编号")
    private String drivingLicense;
    @Comment("准驾车型0")
    private String vehicleClass;
    // 	0..1	an..128	使用总质量 4.5 吨及以下普通货运车辆从事
    //普通货物运输经营的驾驶员必填，根据机动车驾驶证填写。
    @Comment("驾驶证发证机关")
    private String issuingOrganizations;
    // 	0..1	n8	使用总质量 4.5 吨及以下普通货运车辆从事普通货物运输经营的驾驶员必填，根据机动车驾驶证填写。YYYYMMDD
    @Comment("驾驶证有效期自")
    private LocalDate validPeriodFrom;
    // 	0..1	n8	使用总质量 4.5 吨及以下普通货运车辆从事
    //普通货物运输经营的驾驶员必填，根据机动车驾驶证填写。YYYYMMDD
    @Comment("驾驶证有效期至")
    private LocalDate validPeriodTo;
    // 	1..1	an..18	必填，驾驶员从业资格证号，使用总质量4.5 吨及以下普通货运车辆从事普通货物运输经营的驾驶员，填写“驾驶员身份证前 6位+000000000000”。
    @Comment("从业资格证号")
    private String qualificationCertificate;
    // 	1..1	an..18	必填。
    @Comment("手机号码")
    private String telephone;
    @Comment("备注")
    private String remark;


    @Comment("附件URL")
    @ElementCollection
    @CollectionTable(name = "internet_driver_attachment_urls")
    private Set<String> driverAttachmentURLs;
    public void addCar(InternetCar car) {
        if (car != null) {
            InternetCars.add(car);
        }

    }


}
